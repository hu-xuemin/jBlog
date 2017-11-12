package com.hxz.jblog.application;

import org.springframework.stereotype.Service;

import com.hxz.jblog.domain.article.Article;
import com.hxz.jblog.infrastructure.dto.ArticleDTO;

@Service
public class ArticleService {

    public Article publish(String title, String content, String username, String password) {
        return new Article();
    }

    public ArticleDTO getArticleDTO(long id) {
        ArticleDTO article = new ArticleDTO();
        article.setArtileId(id);
        article.setArticleTitle("abc");
        article.setArticleContent("def");
        return article;
    }

}
