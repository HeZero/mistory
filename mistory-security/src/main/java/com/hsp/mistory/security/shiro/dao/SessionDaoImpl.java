package com.hsp.mistory.security.shiro.dao;

import com.hsp.mistory.redis.RedisDao;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by hsp on 2017/11/5.
 */
public class SessionDaoImpl extends EnterpriseCacheSessionDAO {

    @Autowired
    RedisDao redisDao;

        // 创建session，保存到数据库
        @Override
        protected Serializable doCreate(Session session) {
            Serializable sessionId = super.doCreate(session);
            redisDao.setObject(session.getId().toString(), session);

            return sessionId;
        }

        // 获取session
        @Override
        protected Session doReadSession(Serializable sessionId) {
            // 先从缓存中获取session，如果没有再去数据库中获取
            Session session = super.doReadSession(sessionId);
            if (session == null) {
                Object object = redisDao.getObject(sessionId.toString());
                if (object != null) {
                    session = (Session)object;
                }
            }
            return session;
        }

        // 更新session的最后一次访问时间
        @Override
        protected void doUpdate(Session session) {
            super.doUpdate(session);
            redisDao.setObject(session.getId().toString(), session);
        }

        // 删除session
        @Override
        protected void doDelete(Session session) {
            super.doDelete(session);
            redisDao.deleteObject(session.getId().toString());
        }

}
