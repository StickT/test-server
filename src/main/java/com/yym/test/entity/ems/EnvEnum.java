package com.benlai.test.entity.ems;

import java.util.Arrays;

/**
 * Created by yaoyimin on 2018/2/5
 */
public enum  EnvEnum {

	TEST(1,"测试机") , BRANCH(2,"branch环境") , TRUNK(3,"trunk环境")
	;

	private Integer code;

	private String desc;

	EnvEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static EnvEnum getByCode(Integer code){
		return Arrays.asList(values()).stream().filter(x->x.getCode().equals(code)).findFirst().orElse(null);
	}
}
