package com.zsw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsw.entity.RoleMenu;

/**
 * @Author
 */
public interface RoleMenuService extends IService<RoleMenu> {

    void deleteRoleMenuByRoleId(Long id);
}