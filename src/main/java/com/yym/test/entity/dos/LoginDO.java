package com.benlai.test.entity.dos;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yaoyimin on 2018/2/2
 */
@Data
public class LoginDO implements Serializable {

	private String userId;

	private String password;

	private static final long serialVersionUID = 1L;
}
