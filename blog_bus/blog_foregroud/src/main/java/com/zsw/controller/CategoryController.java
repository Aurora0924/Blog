package com.zsw.controller;

import com.zsw.ResponseResult;
import com.zsw.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 分类表(Category)表控制层
 *
 * @author makejava
 * @since 2023-12-09 18:46:19
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }

}

