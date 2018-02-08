package com.benlai.test.entity.ems;

import java.util.Arrays;

/**
 * Created by yaoyimin on 2018/2/5
 */
public enum TestResultEnum {

	INIT(0 , "初始") , SUCCESS(1,"测试成功") , FAILED(2,"测试失败")
	;

	private Integer code;

	private String desc;

	TestResultEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static TestResultEnum getByCode(Integer code){
		return Arrays.asList(values()).stream().filter(x->x.getCode().equals(code)).findFirst().orElse(null);
	}
}
