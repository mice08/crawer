package com.mk.crawer.biz.servcie.impl;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mk.crawer.biz.servcie.CacheSyncService;
import com.mk.framework.MkJedisConnectionFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class CacheSyncServiceImpl implements CacheSyncService {
	private final Logger logger = Logger.getLogger(CacheSyncServiceImpl.class);

	@Override
	public void sync(String fromHostAndPort, String fromMasterName, String hostAndPort, String masterName)
			throws Exception {
		Set<String> fromHostsAndPorts = StringUtils.commaDelimitedListToSet(fromHostAndPort);

		RedisSentinelConfiguration fromSentinelConfiguration = new RedisSentinelConfiguration(fromMasterName,
				fromHostsAndPorts);

		Set<String> sentinelHostAndPorts = StringUtils.commaDelimitedListToSet(hostAndPort);

		RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration(masterName,
				sentinelHostAndPorts);

		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(20);
		poolConfig.setMinIdle(8);
		poolConfig.setMaxTotal(500);

		MkJedisConnectionFactory toFactory = new MkJedisConnectionFactory(sentinelConfiguration, poolConfig);
		MkJedisConnectionFactory fromFactory = new MkJedisConnectionFactory(fromSentinelConfiguration, poolConfig);

		Jedis fromJedis = fromFactory.getJedis();
		Jedis toJedis = toFactory.getJedis();

		Set<String> fromKeys = fromJedis.keys("*");
		for (String fromKey : fromKeys) {
			try {
				String val = fromJedis.get(fromKey);

				toJedis.set(fromKey, val);
			} catch (Exception ex) {
				logger.error(String.format("failed to sync for key :%s", fromKey), ex);
			}
		}

		try {
			fromJedis.close();
			toJedis.close();
		} catch (Exception ex) {
			logger.error("failed to close jedis...", ex);
		}
	}
}
