package com.jblog.web.restAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jblog.application.ArticleService;
import com.jblog.domain.article.ArticleNotFoundException;
import com.jblog.infrastructure.ErrorMessage;
import com.jblog.infrastructure.dto.ArticleDTO;

@RestController
@RequestMapping(value = "/api/article")
public class ArticleAPI {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET, produces = { "application/json",
            "application/xml" })
    public ResponseEntity<ArticleDTO> article(@PathVariable long articleId) {
        return new ResponseEntity<ArticleDTO>(articleService.getArticleDTO(articleId), HttpStatus.OK);
    }

    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<ErrorMessage> articleNotFoundException(ArticleNotFoundException exception) {
        ErrorMessage error = new ErrorMessage(1, exception.getMessage());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }
}
