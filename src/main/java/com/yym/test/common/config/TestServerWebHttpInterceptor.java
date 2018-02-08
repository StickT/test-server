package com.benlai.test.common.config;

import com.benlai.test.common.constants.TestConstants;
import com.benlai.test.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yaoyimin on 2018/2/1
 */
@Configuration
public class TestServerWebHttpInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		String token = request.getHeader(TestConstants.TOKEN);
		if (StringUtils.isEmpty(token)){
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}

		Claims claims = null;
		try {
			claims= JwtUtils.getMap(token);
		} catch (Exception e) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}

		String userId = claims.get(TestConstants.USER_ID,String.class);
		if(userId == null){
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}

		RequestContextHolder.getRequestAttributes().setAttribute(TestConstants.USER_ID,userId, RequestAttributes.SCOPE_SESSION);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
