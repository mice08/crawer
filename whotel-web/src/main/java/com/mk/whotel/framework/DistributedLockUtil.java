package com.mk.whotel.framework;

import redis.clients.jedis.Jedis;

public class DistributedLockUtil {

	private static MkJedisConnectionFactory connectionFactory = null;

	/**
	 * 加锁.
	 *
	 * @param key
	 * @param expireTime
	 *            超时时间单位秒.
	 * @return 锁定的value,返回null值加锁失败,供释放锁时使用.
	 */
	public static String tryLock(String key, int expireTime) {
		Jedis jedis = DistributedLockUtil.getJedis();
		try {
			String value = Long.toString(System.currentTimeMillis() + (expireTime * 1000));
			String result = jedis.set(key, value, "NX", "EX", expireTime);
			if (result == null) {
				return null;
			}
			return value;
		} finally {
			jedis.close();
		}
	}

	/**
	 * 释放锁,finally中调用.
	 *
	 * @param key
	 * @param value
	 *            tryLock返回值.
	 */
	public static void releaseLock(String key, String value) {
		// 加锁失败情况判断.
		if (value == null) {
			return;
		}
		Jedis jedis = DistributedLockUtil.getJedis();
		try {
			String cacheValue = jedis.get(key);
			// 超时释放或者当前key已经被其他线程锁定.
			if ((cacheValue == null) || !value.equals(cacheValue)) {
				return;
			}
			jedis.del(key);
		} finally {
			jedis.close();
		}
	}

	private static Jedis getJedis() {
		return DistributedLockUtil.getConnectionFactory().getJedis();
	}

	private static MkJedisConnectionFactory getConnectionFactory() {
		if (DistributedLockUtil.connectionFactory == null) {
			synchronized (DistributedLockUtil.class) {
				if (DistributedLockUtil.connectionFactory == null) {
					DistributedLockUtil.connectionFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
				}
			}
		}
		return DistributedLockUtil.connectionFactory;
	}
}
