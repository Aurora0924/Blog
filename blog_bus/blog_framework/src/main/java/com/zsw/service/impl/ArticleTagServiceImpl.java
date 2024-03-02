package com.zsw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsw.entity.ArticleTag;
import com.zsw.mapper.ArticleTagMapper;
import com.zsw.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * @Author zsw
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {
}
