package com.benlai.test.controller;

import com.benlai.test.common.base.BaseController;
import com.benlai.test.common.exceptions.TestException;
import com.benlai.test.common.utils.JwtUtils;
import com.benlai.test.entity.dos.LoginDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaoyimin on 2018/2/2
 */
@RequestMapping("/test/sys")
@RestController
public class SysController extends BaseController {

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginDO loginDO){

		if (StringUtils.isEmpty(loginDO.getUserId()) || StringUtils.isEmpty(loginDO.getPassword())){
			throw new TestException(50651,"用户名或者密码不能为空!");
		}

		if (!checkUser(loginDO.getUserId(),loginDO.getPassword())){
			throw new TestException(50652,"用户名或者密码错误!");
		}

		Map<String,Object> result = new HashMap<>();

		result.put("userId",loginDO.getUserId());

		String token = JwtUtils.generateToken(result);

		MultiValueMap<String, String> httpHeaders = new HttpHeaders();
		httpHeaders.add("token",token);

		return new ResponseEntity<>(result , httpHeaders , HttpStatus.OK);
	}

	private Boolean checkUser(String userId , String password){

		if ("admin".equals(userId) && "123456".equals(password)){
			return true;
		}

		return false;
	}

	@PostMapping("/logout")
	public ResponseEntity logout(){
		return OK();
	}
}
