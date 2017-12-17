package com.jblog.repository.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jblog.domain.article.Article;
import com.jblog.repository.ArticleRepository;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository{

    @Autowired  
    private SqlSessionTemplate sqlSession; 

    @Override
    public Article getArticle(int id) {
        return sqlSession.selectOne("ARTICLE.getArticle", 111);
    }

    @Override
    public int count() {
        return sqlSession.selectOne("ARTICLE.count");
    }

}
