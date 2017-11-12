package com.hsp.mistory.manage.controller;

import com.hsp.mistory.common.pojo.User;
import com.hsp.mistory.security.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hsp on 2017/11/5.
 */
@Controller
@RequestMapping(value = "/manage/")
public class LoginController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "login")
    public String toLogin(HttpServletRequest request) {
        User selectUser = userService.selectById(1);
        request.setAttribute("hello","hello");
        request.setAttribute("user", selectUser);
        return "login";
    }



}
