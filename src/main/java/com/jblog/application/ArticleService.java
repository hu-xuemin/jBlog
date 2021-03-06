package com.jblog.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblog.domain.article.Article;
import com.jblog.domain.article.ArticleFactory;
import com.jblog.domain.article.ArticleNotFoundException;
import com.jblog.infrastructure.dto.ArticleDTO;
import com.jblog.repository.ArticleRepository;

@Service
public class ArticleService {
    
    @Autowired
    ArticleRepository articleRepository;
    
    public Article publish(String title, String content, String username, String password) {
        return new Article();
    }

    public ArticleDTO getArticleDTO(long id) {
        /*ArticleDTO article = new ArticleDTO();
        article.setArtileId(id);
        article.setArticleTitle("abc");
        article.setArticleContent("def");
        return article;*/
        Article article = articleRepository.getArticle(id);
        if (article != null) {
            return ArticleFactory.createArticleDTO(article);
        } else {
            throw new ArticleNotFoundException();
        }
    }
    
    public int count(){
        return articleRepository.count();
    }
}