package com.mk.whotel.framework.jedis;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.*;
import redis.clients.jedis.JedisCluster.Reset;
import redis.clients.util.Pool;
import redis.clients.util.Slowlog;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MkJedis extends Jedis  {

	public MkJedis(JedisShardInfo shardInfo) {
		super(shardInfo);
	}

	public MkJedis(String host, int port, int timeout) {
		super(host, port, timeout);
	}

	public MkJedis(String host, int port) {
		super(host, port);
	}

	public MkJedis(String host) {
		super(host);
	}

	public MkJedis(URI uri, int timeout) {
		super(uri, timeout);
	}

	public MkJedis(URI uri) {
		super(uri);
	}

	@Override
	public String set(String key, String value){
		String result = null;
		Transaction t = Cat.newTransaction("Redis", "set");
		try {
			result = super.set(key, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String set(String key, String value, String nxxx, String expx, long time) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "set");
		try {
			result = super.set(key, value, nxxx, expx, time);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public byte[] get(byte[] key) {

		byte[] result = null;
		Transaction t = Cat.newTransaction("Redis", "get");
		try {
			result = super.get(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long del(byte[]... keys) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "del");
		try {
			result = super.del(keys);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long del(byte[] key) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "del");
		try {
			result = super.del(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String set(byte[] key, byte[] value) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "set");
		try {
			result = super.set(key, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "set");
		try {
			result = super.set(key, value, nxxx, expx, time);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String set(byte[] key, byte[] value, byte[] nxxx) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "set");
		try {
			result = super.set(key, value, nxxx);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, int time) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "set");
		try {
			result = super.set(key, value, nxxx, expx, time);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String get(String key) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "get");
		try {
			result = super.get(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Boolean exists(String key) {

		Boolean result = null;
		Transaction t = Cat.newTransaction("Redis", "exists");
		try {
			result = super.exists(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long del(String... keys) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "del");
		try {
			result = super.del(keys);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long del(String key) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "del");
		try {
			result = super.del(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String type(String key) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "type");
		try {
			result = super.type(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Set<String> keys(String pattern) {

		Set<String> result = null;
		Transaction t = Cat.newTransaction("Redis", "keys");
		try {
			result = super.keys(pattern);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String randomKey() {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "randomKey");
		try {
			result = super.randomKey();
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String rename(String oldkey, String newkey) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "rename");
		try {
			result = super.rename(oldkey, newkey);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long renamenx(String oldkey, String newkey) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "renamenx");
		try {
			result = super.renamenx(oldkey, newkey);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long expire(String key, int seconds) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "expire");
		try {
			result = super.expire(key, seconds);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long expireAt(String key, long unixTime) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "expireAt");
		try {
			result = super.expireAt(key, unixTime);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long ttl(String key) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "ttl");
		try {
			result = super.ttl(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long move(String key, int dbIndex) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "move");
		try {
			result = super.move(key, dbIndex);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String getSet(String key, String value) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "getSet");
		try {
			result = super.getSet(key, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override

	public List<String> mget(String... keys){

		List<String> result = null;
		Transaction t = Cat.newTransaction("Redis", "mget");
		try {
			result = super.mget(keys);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long setnx(String key, String value) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "setnx");
		try {
			result = super.setnx(key, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String setex(String key, int seconds, String value) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "setex");
		try {
			result = super.setex(key, seconds, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String mset(String... keysvalues) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "mset");
		try {
			result = super.mset(keysvalues);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long msetnx(String... keysvalues) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "msetnx");
		try {
			result = super.msetnx(keysvalues);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long decrBy(String key, long integer) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "decrBy");
		try {
			result = super.decrBy(key, integer);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long decr(String key) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "decr");
		try {
			result = super.decr(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long incrBy(String key, long integer) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "incrBy");
		try {
			result = super.incrBy(key, integer);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Double incrByFloat(String key, double value) {

		Double result = null;
		Transaction t = Cat.newTransaction("Redis", "incrByFloat");
		try {
			result = super.incrByFloat(key, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long incr(String key) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "incr");
		try {
			result = super.incr(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long append(String key, String value) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "append");
		try {
			result = super.append(key, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String substr(String key, int start, int end) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "substr");
		try {
			result = super.substr(key, start, end);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long hset(String key, String field, String value) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "hset");
		try {
			result = super.hset(key, field, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String hget(String key, String field) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "hget");
		try {
			result = super.hget(key, field);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long hsetnx(String key, String field, String value) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "hsetnx");
		try {
			result = super.hsetnx(key, field, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String hmset(String key, Map<String, String> hash) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "hmset");
		try {
			result = super.hmset(key, hash);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public List<String> hmget(String key, String... fields) {

		List<String> result = null;
		Transaction t = Cat.newTransaction("Redis", "hmget");
		try {
			result = super.hmget(key, fields);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long hincrBy(String key, String field, long value) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "hincrBy");
		try {
			result = super.hincrBy(key, field, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Double hincrByFloat(String key, String field, double value) {

		Double result = null;
		Transaction t = Cat.newTransaction("Redis", "hincrByFloat");
		try {
			result = super.hincrByFloat(key, field, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Boolean hexists(String key, String field) {

		Boolean result = null;
		Transaction t = Cat.newTransaction("Redis", "hexists");
		try {
			result = super.hexists(key, field);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long hdel(String key, String... fields) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "hdel");
		try {
			result = super.hdel(key, fields);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long hlen(String key) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "hlen");
		try {
			result = super.hlen(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Set<String> hkeys(String key) {

		Set<String> result = null;
		Transaction t = Cat.newTransaction("Redis", "hkeys");
		try {
			result = super.hkeys(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public List<String> hvals(String key) {

		List<String> result = null;
		Transaction t = Cat.newTransaction("Redis", "hvals");
		try {
			result = super.hvals(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Map<String, String> hgetAll(String key) {

		Map<String, String> result = null;
		Transaction t = Cat.newTransaction("Redis", "hgetAll");
		try {
			result = super.hgetAll(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long rpush(String key, String... strings) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "rpush");
		try {
			result = super.rpush(key, strings);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long lpush(String key, String... strings) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "lpush");
		try {
			result = super.lpush(key, strings);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long llen(String key) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "llen");
		try {
			result = super.llen(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public List<String> lrange(String key, long start, long end) {

		List<String> result = null;
		Transaction t = Cat.newTransaction("Redis", "lrange");
		try {
			result = super.lrange(key, start, end);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;

	}

	@Override
	public String ltrim(String key, long start, long end) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "ltrim");
		try {
			result = super.ltrim(key, start, end);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;

	}

	@Override
	public String lindex(String key, long index) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "lindex");
		try {
			result = super.lindex(key, index);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String lset(String key, long index, String value) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "lset");
		try {
			result = super.lset(key, index, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long lrem(String key, long count, String value) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "lrem");
		try {
			result = super.lrem(key, count, value);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String lpop(String key) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "lpop");
		try {
			result = super.lpop(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String rpop(String key) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "rpop");
		try {
			result = super.rpop(key);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String rpoplpush(String srckey, String dstkey) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "rpoplpush");
		try {
			result = super.rpoplpush(srckey, dstkey);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long sadd(String key, String... members) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "sadd");
		try {
			result = super.sadd(key, members);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Set<String> smembers(String key) {

		return super.smembers(key);
	}

	@Override
	public Long srem(String key, String... members) {

		return super.srem(key, members);
	}

	@Override
	public String spop(String key) {

		return super.spop(key);
	}

	@Override
	public Long smove(String srckey, String dstkey, String member) {

		return super.smove(srckey, dstkey, member);
	}

	@Override
	public Long scard(String key) {

		return super.scard(key);
	}

	@Override
	public Boolean sismember(String key, String member) {

		return super.sismember(key, member);
	}

	@Override
	public Set<String> sinter(String... keys) {

		return super.sinter(keys);
	}

	@Override
	public Long sinterstore(String dstkey, String... keys) {

		return super.sinterstore(dstkey, keys);
	}

	@Override
	public Set<String> sunion(String... keys) {

		return super.sunion(keys);
	}

	@Override
	public Long sunionstore(String dstkey, String... keys) {

		return super.sunionstore(dstkey, keys);
	}

	@Override
	public Set<String> sdiff(String... keys) {

		return super.sdiff(keys);
	}

	@Override
	public Long sdiffstore(String dstkey, String... keys) {

		return super.sdiffstore(dstkey, keys);
	}

	@Override
	public String srandmember(String key) {

		return super.srandmember(key);
	}

	@Override
	public List<String> srandmember(String key, int count) {

		return super.srandmember(key, count);
	}

	@Override
	public Long zadd(String key, double score, String member) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "zadd");
		try {
			result = super.zadd(key, score, member);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long zadd(String key, Map<String, Double> scoreMembers) {

		Long result = null;
		Transaction t = Cat.newTransaction("Redis", "zadd");
		try {
			result = super.zadd(key, scoreMembers);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Set<String> zrange(String key, long start, long end) {

		Set<String> result = null;
		Transaction t = Cat.newTransaction("Redis", "zrange");
		try {
			result = super.zrange(key, start, end);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public Long zrem(String key, String... members) {

		return super.zrem(key, members);
	}

	@Override
	public Double zincrby(String key, double score, String member) {

		return super.zincrby(key, score, member);
	}

	@Override
	public Long zrank(String key, String member) {

		return super.zrank(key, member);
	}

	@Override
	public Long zrevrank(String key, String member) {

		return super.zrevrank(key, member);
	}

	@Override
	public Set<String> zrevrange(String key, long start, long end) {

		return super.zrevrange(key, start, end);
	}

	@Override
	public Set<Tuple> zrangeWithScores(String key, long start, long end) {

		return super.zrangeWithScores(key, start, end);
	}

	@Override
	public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {

		return super.zrevrangeWithScores(key, start, end);
	}

	@Override
	public Long zcard(String key) {

		return super.zcard(key);
	}

	@Override
	public Double zscore(String key, String member) {

		return super.zscore(key, member);
	}

	@Override
	public String watch(String... keys) {

		return super.watch(keys);
	}

	@Override
	public List<String> sort(String key) {

		return super.sort(key);
	}

	@Override
	public List<String> sort(String key, SortingParams sortingParameters) {

		return super.sort(key, sortingParameters);
	}

	@Override
	public List<String> blpop(int timeout, String... keys) {

		return super.blpop(timeout, keys);
	}

	@Override
	public List<String> blpop(String... args) {

		return super.blpop(args);
	}

	@Override
	public List<String> brpop(String... args) {

		return super.brpop(args);
	}

	@Override
	public List<String> blpop(String arg) {

		return super.blpop(arg);
	}

	@Override
	public List<String> brpop(String arg) {

		return super.brpop(arg);
	}

	@Override
	public Long sort(String key, SortingParams sortingParameters, String dstkey) {

		return super.sort(key, sortingParameters, dstkey);
	}

	@Override
	public Long sort(String key, String dstkey) {

		return super.sort(key, dstkey);
	}

	@Override
	public List<String> brpop(int timeout, String... keys) {

		return super.brpop(timeout, keys);
	}

	@Override
	public Long zcount(String key, double min, double max) {

		return super.zcount(key, min, max);
	}

	@Override
	public Long zcount(String key, String min, String max) {

		return super.zcount(key, min, max);
	}

	@Override
	public Set<String> zrangeByScore(String key, double min, double max) {

		return super.zrangeByScore(key, min, max);
	}

	@Override
	public Set<String> zrangeByScore(String key, String min, String max) {

		return super.zrangeByScore(key, min, max);
	}

	@Override
	public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {

		return super.zrangeByScore(key, min, max, offset, count);
	}

	@Override
	public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {

		return super.zrangeByScore(key, min, max, offset, count);
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {

		return super.zrangeByScoreWithScores(key, min, max);
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {

		return super.zrangeByScoreWithScores(key, min, max);
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {

		return super.zrangeByScoreWithScores(key, min, max, offset, count);
	}

	@Override
	public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {

		return super.zrangeByScoreWithScores(key, min, max, offset, count);
	}

	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min) {

		return super.zrevrangeByScore(key, max, min);
	}

	@Override
	public Set<String> zrevrangeByScore(String key, String max, String min) {

		return super.zrevrangeByScore(key, max, min);
	}

	@Override
	public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {

		return super.zrevrangeByScore(key, max, min, offset, count);
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {

		return super.zrevrangeByScoreWithScores(key, max, min);
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {

		return super.zrevrangeByScoreWithScores(key, max, min, offset, count);
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {

		return super.zrevrangeByScoreWithScores(key, max, min, offset, count);
	}

	@Override
	public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {

		return super.zrevrangeByScore(key, max, min, offset, count);
	}

	@Override
	public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {

		return super.zrevrangeByScoreWithScores(key, max, min);
	}

	@Override
	public Long zremrangeByRank(String key, long start, long end) {

		return super.zremrangeByRank(key, start, end);
	}

	@Override
	public Long zremrangeByScore(String key, double start, double end) {

		return super.zremrangeByScore(key, start, end);
	}

	@Override
	public Long zremrangeByScore(String key, String start, String end) {

		return super.zremrangeByScore(key, start, end);
	}

	@Override
	public Long zunionstore(String dstkey, String... sets) {

		return super.zunionstore(dstkey, sets);
	}

	@Override
	public Long zunionstore(String dstkey, ZParams params, String... sets) {

		return super.zunionstore(dstkey, params, sets);
	}

	@Override
	public Long zinterstore(String dstkey, String... sets) {

		return super.zinterstore(dstkey, sets);
	}

	@Override
	public Long zinterstore(String dstkey, ZParams params, String... sets) {

		return super.zinterstore(dstkey, params, sets);
	}

	@Override
	public Long zlexcount(String key, String min, String max) {

		return super.zlexcount(key, min, max);
	}

	@Override
	public Set<String> zrangeByLex(String key, String min, String max) {

		return super.zrangeByLex(key, min, max);
	}

	@Override
	public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {

		return super.zrangeByLex(key, min, max, offset, count);
	}

	@Override
	public Long zremrangeByLex(String key, String min, String max) {

		return super.zremrangeByLex(key, min, max);
	}

	@Override
	public Long strlen(String key) {

		return super.strlen(key);
	}

	@Override
	public Long lpushx(String key, String... string) {

		return super.lpushx(key, string);
	}

	@Override
	public Long persist(String key) {

		return super.persist(key);
	}

	@Override
	public Long rpushx(String key, String... string) {

		return super.rpushx(key, string);
	}

	@Override
	public String echo(String string) {

		return super.echo(string);
	}

	@Override
	public Long linsert(String key, LIST_POSITION where, String pivot, String value) {

		return super.linsert(key, where, pivot, value);
	}

	@Override
	public String brpoplpush(String source, String destination, int timeout) {

		return super.brpoplpush(source, destination, timeout);
	}

	@Override
	public Boolean setbit(String key, long offset, boolean value) {

		return super.setbit(key, offset, value);
	}

	@Override
	public Boolean setbit(String key, long offset, String value) {

		return super.setbit(key, offset, value);
	}

	@Override
	public Boolean getbit(String key, long offset) {

		return super.getbit(key, offset);
	}

	@Override
	public Long setrange(String key, long offset, String value) {

		return super.setrange(key, offset, value);
	}

	@Override
	public String getrange(String key, long startOffset, long endOffset) {

		return super.getrange(key, startOffset, endOffset);
	}

	@Override
	public Long bitpos(String key, boolean value) {

		return super.bitpos(key, value);
	}

	@Override
	public Long bitpos(String key, boolean value, BitPosParams params) {

		return super.bitpos(key, value, params);
	}

	@Override
	public List<String> configGet(String pattern) {

		return super.configGet(pattern);
	}

	@Override
	public String configSet(String parameter, String value) {

		return super.configSet(parameter, value);
	}

	@Override
	public Object eval(String script, int keyCount, String... params) {

		return super.eval(script, keyCount, params);
	}

	@Override
	public void subscribe(JedisPubSub jedisPubSub, String... channels) {

		super.subscribe(jedisPubSub, channels);
	}

	@Override
	public Long publish(String channel, String message) {

		return super.publish(channel, message);
	}

	@Override
	public void psubscribe(JedisPubSub jedisPubSub, String... patterns) {

		super.psubscribe(jedisPubSub, patterns);
	}

	@Override
	public Object eval(String script, List<String> keys, List<String> args) {

		return super.eval(script, keys, args);
	}

	@Override
	public Object eval(String script) {

		return super.eval(script);
	}

	@Override
	public Object evalsha(String script) {

		return super.evalsha(script);
	}

	@Override
	public Object evalsha(String sha1, List<String> keys, List<String> args) {

		return super.evalsha(sha1, keys, args);
	}

	@Override
	public Object evalsha(String sha1, int keyCount, String... params) {

		return super.evalsha(sha1, keyCount, params);
	}

	@Override
	public Boolean scriptExists(String sha1) {

		return super.scriptExists(sha1);
	}

	@Override
	public List<Boolean> scriptExists(String... sha1) {

		return super.scriptExists(sha1);
	}

	@Override
	public String scriptLoad(String script) {

		return super.scriptLoad(script);
	}

	@Override
	public List<Slowlog> slowlogGet() {

		return super.slowlogGet();
	}

	@Override
	public List<Slowlog> slowlogGet(long entries) {

		return super.slowlogGet(entries);
	}

	@Override
	public Long objectRefcount(String string) {

		return super.objectRefcount(string);
	}

	@Override
	public String objectEncoding(String string) {

		return super.objectEncoding(string);
	}

	@Override
	public Long objectIdletime(String string) {

		return super.objectIdletime(string);
	}

	@Override
	public Long bitcount(String key) {

		return super.bitcount(key);
	}

	@Override
	public Long bitcount(String key, long start, long end) {

		return super.bitcount(key, start, end);
	}

	@Override
	public Long bitop(BitOP op, String destKey, String... srcKeys) {

		return super.bitop(op, destKey, srcKeys);
	}

	@Override
	public List<Map<String, String>> sentinelMasters() {

		return super.sentinelMasters();
	}

	@Override
	public List<String> sentinelGetMasterAddrByName(String masterName) {

		return super.sentinelGetMasterAddrByName(masterName);
	}

	@Override
	public Long sentinelReset(String pattern) {

		return super.sentinelReset(pattern);
	}

	@Override
	public List<Map<String, String>> sentinelSlaves(String masterName) {

		return super.sentinelSlaves(masterName);
	}

	@Override
	public String sentinelFailover(String masterName) {

		return super.sentinelFailover(masterName);
	}

	@Override
	public String sentinelMonitor(String masterName, String ip, int port, int quorum) {

		return super.sentinelMonitor(masterName, ip, port, quorum);
	}

	@Override
	public String sentinelRemove(String masterName) {

		return super.sentinelRemove(masterName);
	}

	@Override
	public String sentinelSet(String masterName, Map<String, String> parameterMap) {

		return super.sentinelSet(masterName, parameterMap);
	}

	@Override
	public byte[] dump(String key) {

		return super.dump(key);
	}

	@Override
	public String restore(String key, int ttl, byte[] serializedValue) {

		return super.restore(key, ttl, serializedValue);
	}

	@Override
	public Long pexpire(String key, int milliseconds) {

		return super.pexpire(key, milliseconds);
	}

	@Override
	public Long pexpire(String key, long milliseconds) {

		return super.pexpire(key, milliseconds);
	}

	@Override
	public Long pexpireAt(String key, long millisecondsTimestamp) {

		return super.pexpireAt(key, millisecondsTimestamp);
	}

	@Override
	public Long pttl(String key) {

		return super.pttl(key);
	}

	@Override
	public String psetex(String key, int milliseconds, String value) {

		return super.psetex(key, milliseconds, value);
	}

	@Override
	public String set(String key, String value, String nxxx) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "set");
		try {
			result = super.set(key, value, nxxx);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;

	}

	@Override
	public String set(String key, String value, String nxxx, String expx, int time) {

		String result = null;
		Transaction t = Cat.newTransaction("Redis", "set");
		try {
			result = super.set(key, value, nxxx, expx, time);
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
		return result;
	}

	@Override
	public String clientKill(String client) {

		return super.clientKill(client);
	}

	@Override
	public String clientSetname(String name) {

		return super.clientSetname(name);
	}

	@Override
	public String migrate(String host, int port, String key, int destinationDb, int timeout) {

		return super.migrate(host, port, key, destinationDb, timeout);
	}

	@Override
	public ScanResult<String> scan(int cursor) {

		return super.scan(cursor);
	}

	@Override
	public ScanResult<String> scan(int cursor, ScanParams params) {

		return super.scan(cursor, params);
	}

	@Override
	public ScanResult<Entry<String, String>> hscan(String key, int cursor) {

		return super.hscan(key, cursor);
	}

	@Override
	public ScanResult<Entry<String, String>> hscan(String key, int cursor, ScanParams params) {

		return super.hscan(key, cursor, params);
	}

	@Override
	public ScanResult<String> sscan(String key, int cursor) {

		return super.sscan(key, cursor);
	}

	@Override
	public ScanResult<String> sscan(String key, int cursor, ScanParams params) {

		return super.sscan(key, cursor, params);
	}

	@Override
	public ScanResult<Tuple> zscan(String key, int cursor) {

		return super.zscan(key, cursor);
	}

	@Override
	public ScanResult<Tuple> zscan(String key, int cursor, ScanParams params) {

		return super.zscan(key, cursor, params);
	}

	@Override
	public ScanResult<String> scan(String cursor) {

		return super.scan(cursor);
	}

	@Override
	public ScanResult<String> scan(String cursor, ScanParams params) {

		return super.scan(cursor, params);
	}

	@Override
	public ScanResult<Entry<String, String>> hscan(String key, String cursor) {

		return super.hscan(key, cursor);
	}

	@Override
	public ScanResult<Entry<String, String>> hscan(String key, String cursor, ScanParams params) {

		return super.hscan(key, cursor, params);
	}

	@Override
	public ScanResult<String> sscan(String key, String cursor) {

		return super.sscan(key, cursor);
	}

	@Override
	public ScanResult<String> sscan(String key, String cursor, ScanParams params) {

		return super.sscan(key, cursor, params);
	}

	@Override
	public ScanResult<Tuple> zscan(String key, String cursor) {

		return super.zscan(key, cursor);
	}

	@Override
	public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {

		return super.zscan(key, cursor, params);
	}

	@Override
	public String clusterNodes() {

		return super.clusterNodes();
	}

	@Override
	public String clusterMeet(String ip, int port) {

		return super.clusterMeet(ip, port);
	}

	@Override
	public String clusterReset(Reset resetType) {

		return super.clusterReset(resetType);
	}

	@Override
	public String clusterAddSlots(int... slots) {

		return super.clusterAddSlots(slots);
	}

	@Override
	public String clusterDelSlots(int... slots) {

		return super.clusterDelSlots(slots);
	}

	@Override
	public String clusterInfo() {

		return super.clusterInfo();
	}

	@Override
	public List<String> clusterGetKeysInSlot(int slot, int count) {

		return super.clusterGetKeysInSlot(slot, count);
	}

	@Override
	public String clusterSetSlotNode(int slot, String nodeId) {

		return super.clusterSetSlotNode(slot, nodeId);
	}

	@Override
	public String clusterSetSlotMigrating(int slot, String nodeId) {

		return super.clusterSetSlotMigrating(slot, nodeId);
	}

	@Override
	public String clusterSetSlotImporting(int slot, String nodeId) {

		return super.clusterSetSlotImporting(slot, nodeId);
	}

	@Override
	public String clusterSetSlotStable(int slot) {

		return super.clusterSetSlotStable(slot);
	}

	@Override
	public String clusterForget(String nodeId) {

		return super.clusterForget(nodeId);
	}

	@Override
	public String clusterFlushSlots() {

		return super.clusterFlushSlots();
	}

	@Override
	public Long clusterKeySlot(String key) {

		return super.clusterKeySlot(key);
	}

	@Override
	public Long clusterCountKeysInSlot(int slot) {

		return super.clusterCountKeysInSlot(slot);
	}

	@Override
	public String clusterSaveConfig() {

		return super.clusterSaveConfig();
	}

	@Override
	public String clusterReplicate(String nodeId) {

		return super.clusterReplicate(nodeId);
	}

	@Override
	public List<String> clusterSlaves(String nodeId) {

		return super.clusterSlaves(nodeId);
	}

	@Override
	public String clusterFailover() {

		return super.clusterFailover();
	}

	@Override
	public List<Object> clusterSlots() {

		return super.clusterSlots();
	}

	@Override
	public String asking() {

		return super.asking();
	}

	@Override
	public List<String> pubsubChannels(String pattern) {

		return super.pubsubChannels(pattern);
	}

	@Override
	public Long pubsubNumPat() {

		return super.pubsubNumPat();
	}

	@Override
	public Map<String, String> pubsubNumSub(String... channels) {

		return super.pubsubNumSub(channels);
	}

	@Override
	public void connect() {
		Transaction t = Cat.newTransaction("Redis", "connect");
		try {
			super.connect();
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
	}

	@Override
	public void close() {

		Transaction t = Cat.newTransaction("Redis", "close");
		try {
			super.close();
			t.setStatus(Transaction.SUCCESS);
		} catch (Exception ex) {
			t.setStatus(ex);
			throw ex;
		} finally {
			t.complete();
		}
	}

	@Override
	public void setDataSource(Pool<Jedis> jedisPool) {

		super.setDataSource(jedisPool);
	}

	@Override
	public Long pfadd(String key, String... elements) {

		return super.pfadd(key, elements);
	}

	@Override
	public long pfcount(String key) {

		return super.pfcount(key);
	}

	@Override
	public long pfcount(String... keys) {

		return super.pfcount(keys);
	}

	@Override
	public String pfmerge(String destkey, String... sourcekeys) {

		return super.pfmerge(destkey, sourcekeys);
	}

	@Override
	public List<String> blpop(int timeout, String key) {

		return super.blpop(timeout, key);
	}

	@Override
	public List<String> brpop(int timeout, String key) {
		return super.brpop(timeout, key);
	}
}
