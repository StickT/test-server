package com.benlai.test.common.exceptions;

/**
 * Created by yaoyimin on 2018/2/2
 */
public class TestException extends RuntimeException {
	private int id;

	private String message;

	public TestException(int id, String message) {
		super(message);
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
