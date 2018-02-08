package com.benlai.test.common.page;

import java.io.Serializable;

/**
 * Created by yaoyimin on 2018/2/2
 */
public class PageResponse<T> implements Serializable {

	private T rows;

	private long total;

	public PageResponse() {
	}

	public PageResponse(T rows, long total) {
		this.rows = rows;
		this.total = total;
	}

	public T getRows() {
		return rows;
	}

	public PageResponse setRows(T rows) {
		this.rows = rows;
		return this;
	}

	public long getTotal() {
		return total;
	}

	public PageResponse setTotal(long total) {
		this.total = total;
		return this;
	}
}
