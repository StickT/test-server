package com.benlai.test.entity.dos;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yaoyimin on 2018/2/5
 */
@Data
public class SystemQueryDO implements Serializable {

	private String name;

	private Integer env;
}
