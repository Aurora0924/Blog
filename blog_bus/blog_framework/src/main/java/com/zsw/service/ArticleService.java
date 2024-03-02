package com.zsw.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zsw.ResponseResult;
import com.zsw.dto.AddArticleDto;
import com.zsw.dto.ArticleDto;
import com.zsw.entity.Article;
import com.zsw.vo.ArticleVo;
import com.zsw.vo.PageVo;

public interface ArticleService extends IService<Article> {
    ResponseResult hostArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);

    ResponseResult add(AddArticleDto article);

    PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize);

    ArticleVo getInfo(Long id);

    void edit(ArticleDto article);
}
