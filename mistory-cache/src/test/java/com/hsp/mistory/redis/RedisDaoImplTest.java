package com.hsp.mistory.redis;

import junit.framework.TestCase;

/**
 * Created by hsp on 2017/11/11.
 */
public class RedisDaoImplTest extends TestCase {

    public void testGetValue() throws Exception {
        RedisDao redisDao = new RedisDaoImpl();
        redisDao.setKey("test", "123");
        System.out.println(redisDao.getValue("test"));
    }

    public void testSetKey() throws Exception {

    }

    public void testExpire() throws Exception {

    }

    public void testExists() throws Exception {

    }

    public void testDelete() throws Exception {

    }

}