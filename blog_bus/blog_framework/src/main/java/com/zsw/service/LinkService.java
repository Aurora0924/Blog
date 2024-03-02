package com.zsw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsw.ResponseResult;
import com.zsw.entity.Link;
import com.zsw.vo.PageVo;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-02-03 12:22:53
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();

    PageVo selectLinkPage(Link link, Integer pageNum, Integer pageSize);
}

