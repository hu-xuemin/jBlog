package com.jblog.config;

import java.util.regex.Pattern;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.jblog.config.RootConfig.WebPackage;

@Configuration
@ImportResource("classpath:applicationContext.xml")
@ComponentScan(basePackages = { "com.jblog" }, excludeFilters = {
		@Filter(type = FilterType.CUSTOM, value = WebPackage.class) })
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class RootConfig {

	public static class WebPackage extends RegexPatternTypeFilter {
		public WebPackage() {
			super(Pattern.compile("com\\.jblog\\.web.*"));
		}
	}
}
