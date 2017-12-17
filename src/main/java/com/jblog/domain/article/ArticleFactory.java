package com.jblog.domain.article;

import java.util.Date;

import com.jblog.infrastructure.dto.ArticleDTO;
import com.jblog.infrastructure.tools.IDCreateFactory;

public class ArticleFactory {

	public static long getId() {
		return IDCreateFactory.getId();
	}

	public static ArticleDTO createArticleDTO(Article article) {
		if (article != null) {
			ArticleDTO dto = new ArticleDTO();
			dto.setArtileId(article.getArticleId());
			dto.setArticleTitle((article.getTitle()));
			dto.setArticleContent(article.getArticleContent());
			return dto;
		} else {
			return null;
		}
	}

	public static Article createArticle(String username, String title, String articlecontent) {
		Article article = new Article(getId(), username, title, articlecontent);
		article.openDiscuss();
		article.classify("talk");
		article.top(new Date(System.currentTimeMillis()));
		return article;
	}
}
