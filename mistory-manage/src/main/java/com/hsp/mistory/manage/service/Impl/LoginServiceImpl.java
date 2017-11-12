package com.hsp.mistory.manage.service.Impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hsp.mistory.common.pojo.User;
import com.hsp.mistory.manage.service.ILoginService;
import com.hsp.mistory.security.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by hsp on 2017/11/12.
 */
@Service
public class LoginServiceImpl implements ILoginService{

    @Reference(version = "1.0")
    IUserService userService;

    public User login(User user) {
        return userService.selectById(1);
    }
}
