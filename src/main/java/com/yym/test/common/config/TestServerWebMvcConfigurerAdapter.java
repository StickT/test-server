package com.benlai.test.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yaoyimin on 2018/2/1
 */
@Configuration
public class TestServerWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

	@Autowired
	TestServerWebHttpInterceptor testServerWebHttpInterceptor;


	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(testServerWebHttpInterceptor).addPathPatterns("/**").excludePathPatterns("/test/sys/login");

		super.addInterceptors(registry);
	}
}
