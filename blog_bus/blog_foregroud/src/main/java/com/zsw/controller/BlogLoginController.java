package com.zsw.controller;

import com.zsw.ResponseResult;
import com.zsw.entity.User;
import com.zsw.enums.AppHttpCodeEnum;
import com.zsw.exception.SystemException;
import com.zsw.service.impl.BlogLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogLoginController {
    @Autowired
    private BlogLoginServiceImpl blogLoginService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        //合法性校验
        if(!StringUtils.hasText(user.getUserName())){
            //提示必须传入参数
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }
    @PostMapping("/logout")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }
}
