package com.benlai.test.service.impl;

import com.benlai.test.common.base.BaseService;
import com.benlai.test.common.page.PageParam;
import com.benlai.test.common.page.PageResponse;
import com.benlai.test.entity.System;
import com.benlai.test.entity.vo.SystemVO;
import com.benlai.test.repository.SystemRepository;
import com.benlai.test.service.ISystemService;
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
public class SystemServiceImpl extends BaseService implements ISystemService {

	@Autowired
	SystemRepository systemRepository;

	@Override
	public PageResponse<List<SystemVO>> query(System query, PageParam pageParam) {

		if (query == null){
			return null;
		}

		Page<System> page = systemRepository.findAll(Example.of(query) , new PageRequest(pageParam.getPageIndex() - 1 , pageParam.getPageSize() , new Sort(Sort.Direction.DESC , "createdOn")) );

		List<System> list = page.getContent();

		List<SystemVO> result = new ArrayList<>();

		for (System system : list){
			SystemVO systemVO = new SystemVO();

			BeanUtils.copyProperties(system, systemVO);

			result.add(systemVO);
		}

		PageResponse<List<SystemVO>> response = new PageResponse<>();

		response.setRows(result);
		response.setTotal(page.getTotalElements());

		return response;
	}

	@Override
	public void create(System system) {

		system.setCreatedBy(getUserId());

		system.setUpdatedBy(getUserId());

		systemRepository.save(system);
	}

	@Override
	public void modify(System system) {
		system.setUpdatedBy(getUserId());
		system.setUpdatedOn(new Date());

		systemRepository.updateSystem(system.getId(), system.getName(), system.getEnv(), system.getBasicUrl(),
				system.getLoginUrl(), system.getLoginType(), system.getLoginUser(), system.getLoginPassword(), system.getUpdatedBy(), system.getUpdatedOn());
	}

	@Override
	public void deleteById(Long id) {
		systemRepository.delete(id);
	}
}
