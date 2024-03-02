package com.zsw.controller;

import com.zsw.ResponseResult;
import com.zsw.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *  * 文章表(Article)表控制层
 *  *
 *  * @author makejava
 *  * @since 2023-12-09 18:46:19
 *
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取热门文章
     * @return
     */
    @GetMapping("hostArticleList")
    public ResponseResult hostArticleList(){
        return articleService.hostArticleList();
    }

    /**
     * 得到文章列表
     * @param categoryId
     * @return
     */
    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){
        return articleService.articleList(pageNum,pageSize,categoryId);
    }
    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateViewCount(@PathVariable("id") Long id){
        return articleService.updateViewCount(id);
    }

    /**
     * 获取文章详细列表
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id){
        return articleService.getArticleDetail(id);
    }
}
