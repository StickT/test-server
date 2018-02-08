package com.benlai.test.service;

import com.benlai.test.common.page.PageParam;
import com.benlai.test.common.page.PageResponse;
import com.benlai.test.entity.SystemGroup;
import com.benlai.test.entity.vo.SystemGroupVO;

import java.util.List;

/**
 * Created by yaoyimin on 2018/2/5
 */
public interface ISystemGroupService {

	PageResponse<List<SystemGroupVO>> query(SystemGroup systemGroup, PageParam pageParam);

	void create(SystemGroup systemGroup);

	void modify(SystemGroup systemGroup);

	void deleteById(Long id);
}
