package com.zsw.service;
import com.zsw.ResponseResult;
import com.zsw.entity.User;

public interface LoginService {
    ResponseResult login(User user);


    ResponseResult logout();
}
