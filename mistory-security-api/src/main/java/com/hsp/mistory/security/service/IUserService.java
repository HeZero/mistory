package com.hsp.mistory.security.service;

import com.hsp.mistory.common.pojo.User;

import java.util.Set;

/**
 * Created by hsp on 2017/11/4.
 */
public interface IUserService {

    int insert(User user);

    int update(User user);

    User select(User user);

    User selectByUsername(String username);

    int delete(Integer id);

    Set<String> findRoles(String username);

    Set<String> findResources(String username);

}
