package com.benlai.test.service;

import com.benlai.test.common.page.PageParam;
import com.benlai.test.common.page.PageResponse;
import com.benlai.test.entity.System;
import com.benlai.test.entity.vo.SystemVO;

import java.util.List;

/**
 * Created by yaoyimin on 2018/2/5
 */
public interface ISystemService {

	PageResponse<List<SystemVO>> query(System query , PageParam pageParam);

	void create(System system);

	void modify(System system);

	void deleteById(Long id);

}
