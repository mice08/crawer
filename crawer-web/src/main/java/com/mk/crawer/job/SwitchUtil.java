package com.mk.crawer.job;

import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.RedisUtil;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * Created by 振涛 on 2016/1/20.
 */
public class SwitchUtil {

    private static final String T = "T";
    private static final String F = "F";

    public static class HotelDetailRefresh {
        public static boolean isOpen() {
            Jedis jedis = RedisUtil.getJedis();
            String flag = jedis.get(RedisCacheName.CRAWLER_SWITCH_HOTEL_DETAIL_REFRESH_KEY);

            if (StringUtils.isEmpty(flag)) {
                flag = F;
                jedis.set(RedisCacheName.CRAWLER_SWITCH_HOTEL_DETAIL_REFRESH_KEY, flag);
            }

            RedisUtil.close(jedis);

            flag = flag.trim();

            if ( T.equals(flag) ) {
                return true;
            } else if (F.equals(flag)) {
                return false;
            } else {
                return false;
            }

        }
    }

}
