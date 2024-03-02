package com.zsw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsw.ResponseResult;
import com.zsw.dto.TagListDto;
import com.zsw.entity.Tag;
import com.zsw.vo.PageVo;
import com.zsw.vo.TagVo;

import java.util.List;


/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2022-07-19 22:33:38
 */
public interface TagService extends IService<Tag> {

    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    List<TagVo> listAllTag();
}

