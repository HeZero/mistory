package com.hsp.mistory.security.service.Impl;

import com.hsp.mistory.common.mapper.ResourceMapper;
import com.hsp.mistory.common.mapper.RoleMapper;
import com.hsp.mistory.common.mapper.UserMapper;
import com.hsp.mistory.common.pojo.User;
import com.hsp.mistory.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by hsp on 2017/11/5.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;


    public int insert(User user) {
        return userMapper.insert(user);
    }

    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User select(User user) {
        return null;
    }

    public User selectByUsername(String username) {
        return null;
    }

    public int delete(Integer id) {
        return 0;
    }

    public Set<String> findRoles(String username) {
        return null;
    }

    public Set<String> findResources(String username) {
        return null;
    }
}
