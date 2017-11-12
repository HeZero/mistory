package com.hsp.mistory.redis;

import com.hsp.utils.SerializeUtil;
import redis.clients.jedis.Jedis;

/**
 * Created by hsp on 2017/11/11.
 */
public class RedisDaoImpl implements RedisDao {

    public static Jedis redisDatasource = ShardedJedisPoolUtil.getredisClient();

    public String getValue(String key) {
        return redisDatasource.get(key);
    }

    public Boolean setKey(String key, String value) {
        Boolean flag = false;
        try {
            redisDatasource.set(key, value);
            flag = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return flag;
    }

    public Boolean expire(String key, int time) {
        Boolean flag = false;
        try {
            redisDatasource.expire(key, time);
            flag = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return flag;
    }

    public Boolean exists(String key) {
        return redisDatasource.exists(key);
    }

    public Boolean delete(String key) {
        Boolean flag = false;
        try {
            redisDatasource.del(key);
            flag = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return flag;
    }

    public Boolean setObject(String key, Object obj) {
        Boolean flag = false;
        try {
            redisDatasource.set(key.getBytes(), SerializeUtil.serialize(obj));
            flag = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return flag;
    }

    public Object getObject(String key) {
        return redisDatasource.get(key.getBytes());
    }

    public Boolean deleteObject(String key) {
        Boolean flag = false;
        try {
            redisDatasource.del(key.getBytes());
            flag = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return flag;
    }

    public Boolean setObject(String key, Object obj, int time) {
        Boolean flag = false;
        try {
            redisDatasource.set(key.getBytes(), SerializeUtil.serialize(obj));
            redisDatasource.expire(key.getBytes(), time);
            flag = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return flag;
    }
}
