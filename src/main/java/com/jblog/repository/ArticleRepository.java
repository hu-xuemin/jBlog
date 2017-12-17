package com.jblog.repository;

import com.jblog.domain.article.Article;

public interface ArticleRepository {
    Article getArticle(int id);
    int count();
}
