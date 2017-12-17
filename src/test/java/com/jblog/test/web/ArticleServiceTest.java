package com.jblog.test.web;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;
import com.jblog.application.ArticleService;
import com.jblog.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class ArticleServiceTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    
    @Autowired
    ArticleService articleService;
    
    @Test
    public void count(){
        /*expectedEx.expect(ArticleNotFoundException.class);
        expectedEx.expectMessage("Article not found!");*/
        Assert.assertTrue("个数：" + articleService.count(),articleService.count() > 1);
    }
}
