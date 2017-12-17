package com.jblog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblog.domain.article.Article;
import com.jblog.domain.article.ArticleFactory;
import com.jblog.infrastructure.dto.ArticleDTO;
import com.jblog.repository.ArticleRepository;

@Service
public class ArticleService {
    
    @Autowired
    ArticleRepository articleRepositoryImpl;
    
    public Article publish(String title, String content, String username, String password) {
        return new Article();
    }

    public ArticleDTO getArticleDTO(long id) {
        /*ArticleDTO article = new ArticleDTO();
        article.setArtileId(id);
        article.setArticleTitle("abc");
        article.setArticleContent("def");
        return article;*/
        return ArticleFactory.createArticleDTO(articleRepositoryImpl.getArticle(111));
    }
    
    public int count(){
        return articleRepositoryImpl.count();
    }
}