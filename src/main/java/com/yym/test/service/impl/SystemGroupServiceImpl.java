package com.benlai.test.service.impl;

import com.benlai.test.common.base.BaseService;
import com.benlai.test.common.page.PageParam;
import com.benlai.test.common.page.PageResponse;
import com.benlai.test.entity.SystemGroup;
import com.benlai.test.entity.vo.SystemGroupVO;
import com.benlai.test.repository.GroupRepository;
import com.benlai.test.service.ISystemGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yaoyimin on 2018/2/5
 */
@Service
public class SystemGroupServiceImpl extends BaseService implements ISystemGroupService {

	@Autowired
	GroupRepository groupRepository;

	@Override
	public PageResponse<List<SystemGroupVO>> query(SystemGroup systemGroup, PageParam pageParam) {

		Page<SystemGroup> page = groupRepository.findAll(Example.of(systemGroup) ,
				new PageRequest(pageParam.getPageIndex()-1 , pageParam.getPageSize(),new Sort(Sort.Direction.DESC,"createdOn")));


		List<SystemGroup> list = page.getContent();

		List<SystemGroupVO> result = new ArrayList<>();

		for (SystemGroup item : list){

			SystemGroupVO systemGroupVO = new SystemGroupVO();

			BeanUtils.copyProperties(item , systemGroupVO);

			result.add(systemGroupVO);
		}

		PageResponse<List<SystemGroupVO>> response = new PageResponse<>();

		response.setRows(result);

		response.setTotal(page.getTotalElements());

		return response;
	}

	@Override
	public void create(SystemGroup systemGroup) {
		systemGroup.setCreatedBy(getUserId());
		systemGroup.setUpdatedBy(getUserId());
		groupRepository.save(systemGroup);
	}

	@Override
	public void modify(SystemGroup systemGroup) {
		systemGroup.setUpdatedBy(getUserId());
		systemGroup.setUpdatedOn(new Date());
		groupRepository.save(systemGroup);
	}

	@Override
	public void deleteById(Long id) {
		groupRepository.delete(id);
	}
}
