package com.hsp.mistory.redis;

/**
 * Created by hsp on 2017/11/11.
 */
public interface RedisDao {

    String getValue(String key);

    Boolean setKey(String key, String value);

    Boolean expire(String key, int time);

    Boolean exists(String key);

    Boolean delete(String key);

    Boolean setObject(String key, Object obj);

    Boolean setObject(String key, Object obj, int time);

    Object getObject(String key);

    Boolean deleteObject(String key);
}
