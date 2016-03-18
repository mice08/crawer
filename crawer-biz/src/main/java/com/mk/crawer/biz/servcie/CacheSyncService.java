package com.mk.crawer.biz.servcie;

public interface CacheSyncService {
	public void sync(String fromHostAndPort, String fromMasterName, String hostAndPort, String masterName)
			throws Exception;
}
