package com.hsp.mistory.redis;

import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by hsp on 2017/11/11.
 */
public class ShardedJedisPoolUtil {

    public static  String HOST = "192.168.0.107";

    public static  int PORT = 6379;

    public static final String HOST_PORT_SEPARATOR = ":";

    public static final int MAX_TOTAL = 8;

    public static final int MAX_IDEL = 8;

    public static final int MIN_IDLE = 0;

    public static final long MAX_WAIT_TIME = -1;

    public static JedisPool JEDISPOOL = null;

    static {
        init();
    }


    public static JedisPool connect() {
        if (JEDISPOOL == null) {
            init();
        }
        return JEDISPOOL;
    }

    public static JedisPool connect(String url) {
        if (StringUtils.isEmpty(url)) {
            throw new RuntimeException("error url is not empty");
        }
        String[] urls = url.split(HOST_PORT_SEPARATOR);
        try {
            int port = Integer.parseInt(urls[1]);
            JedisPoolConfig jedisPoolConfig = initConfig();
            JEDISPOOL = new JedisPool(jedisPoolConfig, urls[0], port);
            if (JEDISPOOL == null) {
                throw new RuntimeException("connect redis client failed");
            }
            return JEDISPOOL;
        } catch (NumberFormatException e) {
            throw new RuntimeException("error: url is illegal");
        }
    }

    public static void init() {
         JedisPoolConfig jedisPoolConfig = initConfig();
         JEDISPOOL = new JedisPool(jedisPoolConfig, HOST, PORT);
        if (JEDISPOOL == null) {
            throw new RuntimeException("connect redis client failed");
        }
    }

    public static JedisPoolConfig initConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(MAX_TOTAL);
        jedisPoolConfig.setMaxIdle(MAX_IDEL);
        jedisPoolConfig.setMinIdle(MIN_IDLE);
        jedisPoolConfig.setMaxWaitMillis(MAX_WAIT_TIME);
        return jedisPoolConfig;
    }

    public static Jedis getredisClient() {
        if (JEDISPOOL == null) {
            connect();
        }
        return JEDISPOOL.getResource();
    }

}
