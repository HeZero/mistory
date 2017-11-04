package com.hsp.mistory.security.service;

import com.hsp.mistory.common.pojo.Role;
import com.hsp.mistory.common.pojo.User;

import java.util.List;

/**
 * Created by hsp on 2017/11/4.
 */
public interface IUserService {

    int insert(User user);

    int update(User user);

    User select(User user);

    User selectByUsername(String username);

    int delete(Integer id);

    List<Role> findRole(User user);

}
