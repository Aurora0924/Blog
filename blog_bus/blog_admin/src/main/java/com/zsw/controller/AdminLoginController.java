package com.zsw.controller;

import com.zsw.ResponseResult;
import com.zsw.config.RedisCache;
import com.zsw.entity.LoginUser;
import com.zsw.entity.Menu;
import com.zsw.entity.User;
import com.zsw.enums.AppHttpCodeEnum;
import com.zsw.exception.SystemException;
import com.zsw.service.LoginService;
import com.zsw.service.MenuService;
import com.zsw.service.RoleService;
import com.zsw.utils.BeanCopyUtils;
import com.zsw.utils.SecurityUtils;
import com.zsw.vo.AdminUserInfoVo;
import com.zsw.vo.RoutersVo;
import com.zsw.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminLoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        //合法性校验
        if(!StringUtils.hasText(user.getUserName())){
            //提示必须传入参数
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    /**
     * 用户退出功能
     * @return
     */
    @PostMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();

    }
    /**
     * 用户权限角色功能
     * @return
     */
    @GetMapping("/getInfo")
    public ResponseResult<AdminUserInfoVo> getInfo(){
        //获取当前登录的userID
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //根据userID查询权限和角色信息
        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
        List<String> roleKeyList = roleService.selectRoleKeyByUserId(loginUser.getUser().getId());
        //属性拷贝获取用户信息
        User user = loginUser.getUser();
        UserInfoVo userInfoVo = BeanCopyUtils.BeanCopy(user, UserInfoVo.class);
        //封装返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms,roleKeyList,userInfoVo);
        return  ResponseResult.SuccessResult(adminUserInfoVo);
    }
    @GetMapping("getRouters")
    public ResponseResult<RoutersVo> getRouters(){
        Long userId = SecurityUtils.getUserId();
        //查询menu 结果希望是true
       List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        //封装数据
        return ResponseResult.SuccessResult(new RoutersVo(menus));
    }
}
