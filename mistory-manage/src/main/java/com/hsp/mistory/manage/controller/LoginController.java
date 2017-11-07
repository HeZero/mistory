package com.hsp.mistory.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hsp.mistory.security.bo.BaseController;
import com.hsp.mistory.security.service.IRoleService;
import com.hsp.mistory.security.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hsp on 2017/11/5.
 */
@Controller
@RequestMapping(value = "/manage/")
public class LoginController extends BaseController {

    @Reference()
    private IUserService userService;

    @Reference
    private IRoleService roleService;

    @RequestMapping(value = "index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "login")
    public String toLogin(HttpServletRequest request) {
        request.setAttribute("hello","hello");
        return "login";
    }



}
