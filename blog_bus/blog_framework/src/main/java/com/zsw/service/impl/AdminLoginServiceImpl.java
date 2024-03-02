package com.zsw.service.impl;

import com.zsw.ResponseResult;
import com.zsw.config.RedisCache;
import com.zsw.entity.LoginUser;
import com.zsw.entity.User;
import com.zsw.service.BlogLoginService;
import com.zsw.service.LoginService;
import com.zsw.utils.BeanCopyUtils;
import com.zsw.utils.JwtUtil;
import com.zsw.utils.SecurityUtils;
import com.zsw.vo.BlogUserLoginVo;
import com.zsw.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class AdminLoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    /**
     * 用户登录功能
     * @param user
     * @return
     */
    public ResponseResult login(User user){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //判断认证是否通过
        if(Objects.isNull(authentication)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取id,生成token
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //存入redis
        redisCache.setCacheObject("AdminLogin:"+userId,loginUser);
        //获取token
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        //封装返回
        return ResponseResult.SuccessResult(map);
    }

    @Override
    public ResponseResult logout() {
        //获取用户id
        Long userId = SecurityUtils.getUserId();
        //删除redis
        redisCache.deleteObject("AdminLogin"+userId);
        return ResponseResult.SuccessResult();
    }
}
