package com.jblog.test.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jblog.config.RootConfig;
import com.jblog.infrastructure.SessionConstant;
import com.jblog.web.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({ @ContextConfiguration(name = "parent", classes = RootConfig.class),
		@ContextConfiguration(name = "child", classes = WebConfig.class) })
public class RestApiWebAppContextTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void destory() {
    }
	@Test
	public void testArticle() throws Exception {
	    mockMvc.perform(
                MockMvcRequestBuilders.get("/api/article/11862601330745").sessionAttr(SessionConstant.USERNAME, "admin")
                        .sessionAttr(SessionConstant.PASSWORD, "admin123").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is(200));
        /*mockMvc.perform(MockMvcRequestBuilders.put("/api/articles/11871121866257")
                .sessionAttr(SessionConstant.USERNAME, "admin").sessionAttr(SessionConstant.PASSWORD, "admin123")
                .content("articleTitle=huxuemin&articleContent=huxuemin")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print());*/
    
	}
}
