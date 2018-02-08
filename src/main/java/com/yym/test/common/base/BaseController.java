package com.benlai.test.common.base;

import com.benlai.test.common.page.PageParam;
import com.benlai.test.common.page.PageResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaoyimin on 2018/2/2
 */
@Component
public abstract class BaseController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	protected HttpSession getSession(){
		return request.getSession();
	}

	public PageParam getRequestPageParam(){
		String page = this.request.getParameter("pageIndex");
		String pageSize = this.request.getParameter("pageSize");
		if(StringUtils.isEmpty(page)){
			page = "1";
		}
		if(StringUtils.isEmpty(pageSize)){
			pageSize = "10";
		}
		return new PageParam(Integer.parseInt(page), Integer.parseInt(pageSize) < 0 ? 10 : Integer.parseInt(pageSize));
	}

	public ResponseEntity<?> getSucPageData(PageResponse<?> response){
		PageParam pageRequestParam = getRequestPageParam();
		Map<String,Object> result = new HashMap<>();
		result.put("total",response.getTotal());
		result.put("rows",response.getRows());
		result.put("current", pageRequestParam.getPageIndex());
		result.put("pageSize",pageRequestParam.getPageSize());
		return ResponseEntity.ok(result);
	}

	public <T> ResponseEntity<?> OK(T data){
		return ResponseEntity.ok().body(data);
	}

	public ResponseEntity OK(){
		return ResponseEntity.ok().build();
	}
}
