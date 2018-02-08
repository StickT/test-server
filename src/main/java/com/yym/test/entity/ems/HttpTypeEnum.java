package com.benlai.test.entity.ems;

import java.util.Arrays;

/**
 * Created by yaoyimin on 2018/2/5
 */
public enum  HttpTypeEnum {

	GET(1,"GET") , POST(2,"POST") , PUT(3,"PUT") , DELETE(4,"DELETE")
	;

	private Integer code;

	private String desc;

	HttpTypeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static HttpTypeEnum getByCode(Integer code){
		return Arrays.asList(values()).stream().filter(x->x.getCode().equals(code)).findFirst().orElse(null);
	}
}
