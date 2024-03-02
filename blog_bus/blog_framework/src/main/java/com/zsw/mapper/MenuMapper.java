package com.zsw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsw.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author zsw
 * @since 2024-02-13 12:56:39
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long userId);

    List<Menu> selectAllMenuRouter();

    List<Menu> selectRouterMenuTreeByUserId(Long userId);


    List<Long> selectMenuListByRoleId(Long roleId);
}

