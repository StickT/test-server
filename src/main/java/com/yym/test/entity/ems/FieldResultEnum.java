package com.benlai.test.entity.ems;

import java.util.Arrays;

/**
 * Created by yaoyimin on 2018/2/5
 */
public enum FieldResultEnum {

	INIT(0 , "初始") , MATCHED(1,"匹配") , DIS_MATCHED(2,"不匹配")
	;

	private Integer code;

	private String desc;

	FieldResultEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static FieldResultEnum getByCode(Integer code){
		return Arrays.asList(values()).stream().filter(x->x.getCode().equals(code)).findFirst().orElse(null);
	}
}
