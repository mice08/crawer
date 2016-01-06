package com.mk.framework;

import com.mk.framework.jedis.MkJedis;
import com.mk.framework.jedis.MkJedisSentinelPool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.data.redis.ExceptionTranslationStrategy;
import org.springframework.data.redis.PassThroughExceptionTranslationStrategy;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConverters;
import org.springframework.data.redis.connection.jedis.JedisSentinelConnection;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.*;
import redis.clients.util.Pool;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;


public class MkJedisConnectionFactory implements InitializingBean, DisposableBean, RedisConnectionFactory {

	private final static Log log = LogFactory.getLog(JedisConnectionFactory.class);
	private static final ExceptionTranslationStrategy EXCEPTION_TRANSLATION = new PassThroughExceptionTranslationStrategy(JedisConverters.exceptionConverter());

	private static final Method SET_TIMEOUT_METHOD;
	private static final Method GET_TIMEOUT_METHOD;

	static {

		// We need to configure Jedis socket timeout via reflection since the method-name was changed between releases.
		Method setTimeoutMethodCandidate = ReflectionUtils.findMethod(JedisShardInfo.class, "setTimeout", int.class);
		if (setTimeoutMethodCandidate == null) {
			// Jedis V 2.7.x changed the setTimeout method to setSoTimeout
			setTimeoutMethodCandidate = ReflectionUtils.findMethod(JedisShardInfo.class, "setSoTimeout", int.class);
		}
		SET_TIMEOUT_METHOD = setTimeoutMethodCandidate;

		Method getTimeoutMethodCandidate = ReflectionUtils.findMethod(JedisShardInfo.class, "getTimeout");
		if (getTimeoutMethodCandidate == null) {
			getTimeoutMethodCandidate = ReflectionUtils.findMethod(JedisShardInfo.class, "getSoTimeout");
		}

		GET_TIMEOUT_METHOD = getTimeoutMethodCandidate;
	}

	private JedisShardInfo shardInfo;
	private String hostName = "localhost";
	private int port = Protocol.DEFAULT_PORT;
	private int timeout = Protocol.DEFAULT_TIMEOUT;
	private String password;
	private boolean usePool = true;
	private Pool<Jedis> pool;
	private JedisPoolConfig poolConfig = new JedisPoolConfig();
	private int dbIndex = 0;
	private boolean convertPipelineAndTxResults = true;
	private RedisSentinelConfiguration sentinelConfig;

	/**
	 * Constructs a new <code>JedisConnectionFactory</code> instance with default settings (default connection pooling, no shard information).
	 */
	public MkJedisConnectionFactory() {
	}

	/**
	 * Constructs a new <code>JedisConnectionFactory</code> instance. Will override the other connection parameters passed to the factory.
	 * 
	 * @param shardInfo
	 *            shard information
	 */
	public MkJedisConnectionFactory(JedisShardInfo shardInfo) {
		this.shardInfo = shardInfo;
	}

	/**
	 * Constructs a new <code>JedisConnectionFactory</code> instance using the given pool configuration.
	 * 
	 * @param poolConfig
	 *            pool configuration
	 */
	public MkJedisConnectionFactory(JedisPoolConfig poolConfig) {
		this(null, poolConfig);
	}

	/**
	 * Constructs a new {@link JedisConnectionFactory} instance using the given {@link redis.clients.jedis.JedisPoolConfig} applied to {@link redis.clients.jedis.JedisSentinelPool}.
	 *
	 * @param sentinelConfig
	 * @since 1.4
	 */
	public MkJedisConnectionFactory(RedisSentinelConfiguration sentinelConfig) {
		this(sentinelConfig, null);
	}

	/**
	 * Constructs a new {@link JedisConnectionFactory} instance using the given {@link redis.clients.jedis.JedisPoolConfig} applied to {@link redis.clients.jedis.JedisSentinelPool}.
	 *
	 * @param sentinelConfig
	 * @param poolConfig
	 *            pool configuration. Defaulted to new instance if {@literal null}.
	 * @since 1.4
	 */
	public MkJedisConnectionFactory(RedisSentinelConfiguration sentinelConfig, JedisPoolConfig poolConfig) {
		this.sentinelConfig = sentinelConfig;
		this.poolConfig = poolConfig != null ? poolConfig : new JedisPoolConfig();
	}

	/**
	 * Returns a Jedis instance to be used as a Redis connection. The instance can be newly created or retrieved from a pool.
	 *
	 * @return Jedis instance ready for wrapping into a {@link RedisConnection}.
	 */
	protected Jedis fetchJedisConnector() {
		try {
			if (usePool && pool != null) {
				return pool.getResource();
			}
			Jedis jedis = new MkJedis(getShardInfo());
			// force initialization (see Jedis issue #82)
			jedis.connect();
			return jedis;
		} catch (Exception ex) {
			throw new RedisConnectionFailureException("Cannot get Jedis connection", ex);
		}
	}

	/**
	 * Post process a newly retrieved connection. Useful for decorating or executing initialization commands on a new connection. This implementation simply returns the connection.
	 *
	 * @param connection
	 * @return processed connection
	 */
	protected JedisConnection postProcessConnection(JedisConnection connection) {
		return connection;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() {
		if (shardInfo == null) {
			shardInfo = new JedisShardInfo(hostName, port);

			if (StringUtils.hasLength(password)) {
				shardInfo.setPassword(password);
			}

			if (timeout > 0) {
				setTimeoutOn(shardInfo, timeout);
			}
		}

		if (usePool) {
			this.pool = createPool();
		}
	}

	private Pool<Jedis> createPool() {

		if (isRedisSentinelAware()) {
			return createRedisSentinelPool(this.sentinelConfig);
		}
		return createRedisPool();
	}

	/**
	 * Creates {@link redis.clients.jedis.JedisSentinelPool}.
	 *
	 * @param config
	 * @return
	 * @since 1.4
	 */
	protected Pool<Jedis> createRedisSentinelPool(RedisSentinelConfiguration config) {
		return new MkJedisSentinelPool(config.getMaster().getName(), convertToJedisSentinelSet(config.getSentinels()), getPoolConfig() != null ? getPoolConfig() : new JedisPoolConfig(), getTimeoutFrom(getShardInfo()), getShardInfo().getPassword());
	}

	/**
	 * Creates {@link redis.clients.jedis.JedisPool}.
	 * 
	 * @return
	 * @since 1.4
	 */
	protected Pool<Jedis> createRedisPool() {
		return new JedisPool(getPoolConfig(), getShardInfo().getHost(), getShardInfo().getPort(), getTimeoutFrom(getShardInfo()), getShardInfo().getPassword());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	public void destroy() {
		if (usePool && pool != null) {
			try {
				pool.destroy();
			} catch (Exception ex) {
				log.warn("Cannot properly close Jedis pool", ex);
			}
			pool = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.redis.connection.RedisConnectionFactory#getConnection()
	 */
	public JedisConnection getConnection() {
		Jedis jedis = fetchJedisConnector();
		JedisConnection connection = (usePool ? new JedisConnection(jedis, pool, dbIndex) : new JedisConnection(jedis, null, dbIndex));
		connection.setConvertPipelineAndTxResults(convertPipelineAndTxResults);
		return postProcessConnection(connection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.dao.support.PersistenceExceptionTranslator#translateExceptionIfPossible(java.lang.RuntimeException)
	 */
	public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
		return EXCEPTION_TRANSLATION.translate(ex);
	}

	/**
	 * Returns the Redis hostName.
	 * 
	 * @return Returns the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * Sets the Redis hostName.
	 * 
	 * @param hostName
	 *            The hostName to set.
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * Returns the password used for authenticating with the Redis server.
	 * 
	 * @return password for authentication
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password used for authenticating with the Redis server.
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the port used to connect to the Redis instance.
	 * 
	 * @return Redis port.
	 */
	public int getPort() {
		return port;

	}

	/**
	 * Sets the port used to connect to the Redis instance.
	 * 
	 * @param port
	 *            Redis port
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Returns the shardInfo.
	 * 
	 * @return Returns the shardInfo
	 */
	public JedisShardInfo getShardInfo() {
		return shardInfo;
	}

	/**
	 * Sets the shard info for this factory.
	 * 
	 * @param shardInfo
	 *            The shardInfo to set.
	 */
	public void setShardInfo(JedisShardInfo shardInfo) {
		this.shardInfo = shardInfo;
	}

	/**
	 * Returns the timeout.
	 * 
	 * @return Returns the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *            The timeout to set.
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * Indicates the use of a connection pool.
	 * 
	 * @return Returns the use of connection pooling.
	 */
	public boolean getUsePool() {
		return usePool;
	}

	/**
	 * Turns on or off the use of connection pooling.
	 * 
	 * @param usePool
	 *            The usePool to set.
	 */
	public void setUsePool(boolean usePool) {
		this.usePool = usePool;
	}

	/**
	 * Returns the poolConfig.
	 * 
	 * @return Returns the poolConfig
	 */
	public JedisPoolConfig getPoolConfig() {
		return poolConfig;
	}

	/**
	 * Sets the pool configuration for this factory.
	 * 
	 * @param poolConfig
	 *            The poolConfig to set.
	 */
	public void setPoolConfig(JedisPoolConfig poolConfig) {
		this.poolConfig = poolConfig;
	}

	/**
	 * Returns the index of the database.
	 * 
	 * @return Returns the database index
	 */
	public int getDatabase() {
		return dbIndex;
	}

	/**
	 * Sets the index of the database used by this connection factory. Default is 0.
	 * 
	 * @param index
	 *            database index
	 */
	public void setDatabase(int index) {
		Assert.isTrue(index >= 0, "invalid DB index (a positive index required)");
		this.dbIndex = index;
	}

	/**
	 * Specifies if pipelined results should be converted to the expected data type. If false, results of {@link JedisConnection#closePipeline()} and {@link JedisConnection#exec()} will be of the type
	 * returned by the Jedis driver
	 * 
	 * @return Whether or not to convert pipeline and tx results
	 */
	public boolean getConvertPipelineAndTxResults() {
		return convertPipelineAndTxResults;
	}

	/**
	 * Specifies if pipelined results should be converted to the expected data type. If false, results of {@link JedisConnection#closePipeline()} and {@link JedisConnection#exec()} will be of the type
	 * returned by the Jedis driver
	 * 
	 * @param convertPipelineAndTxResults
	 *            Whether or not to convert pipeline and tx results
	 */
	public void setConvertPipelineAndTxResults(boolean convertPipelineAndTxResults) {
		this.convertPipelineAndTxResults = convertPipelineAndTxResults;
	}

	/**
	 * @return true when {@link RedisSentinelConfiguration} is present.
	 * @since 1.4
	 */
	public boolean isRedisSentinelAware() {
		return sentinelConfig != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.redis.connection.RedisConnectionFactory#getSentinelConnection()
	 */
	@Override
	public RedisSentinelConnection getSentinelConnection() {

		if (!isRedisSentinelAware()) {
			throw new InvalidDataAccessResourceUsageException("No Sentinels configured");
		}

		return new JedisSentinelConnection(getActiveSentinel());
	}

	private Jedis getActiveSentinel() {

		Assert.notNull(this.sentinelConfig);
		for (RedisNode node : this.sentinelConfig.getSentinels()) {
			Jedis jedis = new MkJedis(node.getHost(), node.getPort());
			if (jedis.ping().equalsIgnoreCase("pong")) {
				return jedis;
			}
		}

		throw new InvalidDataAccessResourceUsageException("no sentinel found");
	}

	private Set<String> convertToJedisSentinelSet(Collection<RedisNode> nodes) {

		if (CollectionUtils.isEmpty(nodes)) {
			return Collections.emptySet();
		}

		Set<String> convertedNodes = new LinkedHashSet<String>(nodes.size());
		for (RedisNode node : nodes) {
			if (node != null) {
				convertedNodes.add(node.asString());
			}
		}
		return convertedNodes;
	}

	private void setTimeoutOn(JedisShardInfo shardInfo, int timeout) {
		ReflectionUtils.invokeMethod(SET_TIMEOUT_METHOD, shardInfo, timeout);
	}

	private int getTimeoutFrom(JedisShardInfo shardInfo) {
		return (Integer) ReflectionUtils.invokeMethod(GET_TIMEOUT_METHOD, shardInfo);
	}

	public Jedis getJedis() {
		return this.fetchJedisConnector();
	}
}
