package com.mk.crawer.web.utils;

import com.mk.crawer.api.enums.BlackUserEnum;
import com.mk.crawer.task.ReFreshBlackListTask;
import org.slf4j.Logger;

/**
 * Created by kirinli on 15/9/9.
 */
public class CacheManager {
    public static Logger log = org.slf4j.LoggerFactory.getLogger(CacheManager.class);

    public static boolean deleteKey(int key) {
        try {
            ReFreshBlackListTask.midBlackMap.remove(key);
            return true;
        } catch (Exception e) {

            log.error("delete Key {} exception {}", key, e.getMessage());
            return false;
        }

    }

    public static boolean deleteKey(String key) {
        try {
            ReFreshBlackListTask.phoneBlackMap.remove(key);
            ReFreshBlackListTask.cardIdBlackMap.remove(key);
            return true;
        } catch (Exception e) {

            log.error("delete Key {} exception {}", key, e.getMessage());
            return false;
        }

    }


    public static boolean add(String key) {
        try {
            ReFreshBlackListTask.phoneBlackMap.put(key, BlackUserEnum.INVALID);
            ReFreshBlackListTask.cardIdBlackMap.put(key, BlackUserEnum.INVALID);
            return true;
        } catch (Exception e) {

            log.error("delete Key {} exception {}", key, e.getMessage());
            return false;
        }

    }

    public static boolean add(int key) {
        try {
            ReFreshBlackListTask.midBlackMap.put(key, BlackUserEnum.INVALID);

            return true;
        } catch (Exception e) {

            log.error("delete Key {} exception {}", key, e.getMessage());
            return false;
        }

    }


}
