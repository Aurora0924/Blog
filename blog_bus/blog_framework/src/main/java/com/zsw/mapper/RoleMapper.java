package com.zsw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsw.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author zsw
 * @since 2024-02-13 13:02:18
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<String> selectRoleKeyByUserId(Long id);

    List<Long> selectRoleIdByUserId(Long userId);
}

