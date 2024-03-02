package com.zsw.controller;

import com.zsw.ResponseResult;
import com.zsw.dto.AddTagDto;
import com.zsw.dto.EditTagDto;
import com.zsw.dto.TagListDto;
import com.zsw.entity.Tag;
import com.zsw.service.TagService;
import com.zsw.utils.BeanCopyUtils;
import com.zsw.vo.PageVo;
import com.zsw.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }

    @PostMapping
    public ResponseResult add(@RequestBody AddTagDto tagDto){
        Tag tag = BeanCopyUtils.BeanCopy(tagDto, Tag.class);
        tagService.save(tag);
        return ResponseResult.SuccessResult();
    }

    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        tagService.removeById(id);
        return ResponseResult.SuccessResult();
    }

    @PutMapping
    public ResponseResult edit(@RequestBody EditTagDto tagDto){
        Tag tag = BeanCopyUtils.BeanCopy(tagDto,Tag.class);
        tagService.updateById(tag);
        return ResponseResult.SuccessResult();
    }
    @GetMapping(value = "/{id}")
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        Tag tag = tagService.getById(id);
        return ResponseResult.SuccessResult(tag);
    }
    @GetMapping("/listAllTag")
    public ResponseResult listAllTag(){
        List<TagVo> list = tagService.listAllTag();
        return ResponseResult.SuccessResult(list);
    }
}
