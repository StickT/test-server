package com.benlai.test.common.page;

/**
 * Created by yaoyimin on 2018/2/2
 */
public class PageParam {

	/**
	 * the current page of this web page
	 * starts from 1
	 */
	private int pageIndex;

	private int pageSize;

	private int offset = 0;

	public PageParam(int pageIndex, int pageSize) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.offset = (pageIndex-1 < 0 ? 0 : pageIndex-1) * pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public PageParam setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
		return this;
	}

	public int getPageSize() {
		return pageSize;
	}

	public PageParam setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public int getOffset() {
		return offset;
	}
}
