package com.hsp.mistory.shiro;

import com.hsp.constant.Constant;
import com.hsp.mistory.common.pojo.User;
import com.hsp.mistory.security.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by hsp on 2017/11/4.
 */
public class UsernamePasswordRealm extends AuthorizingRealm{

    @Autowired
    IUserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.selectByUsername(username);
        if (user == null) {
            throw new UnknownAccountException();
        }else if (StringUtils.equals(Constant.LOCK,user.getStatus())) {
            throw new LockedAccountException();
        }else {
            user.setLoginTime(new Date());
            userService.update(user);
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getUsername()), getName());
            return authenticationInfo;
        }
    }
}
