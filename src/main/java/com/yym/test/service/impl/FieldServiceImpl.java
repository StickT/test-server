package com.benlai.test.service.impl;

import com.benlai.test.common.base.BaseService;
import com.benlai.test.common.page.PageParam;
import com.benlai.test.common.page.PageResponse;
import com.benlai.test.entity.Field;
import com.benlai.test.entity.vo.FieldVO;
import com.benlai.test.repository.FieldRepository;
import com.benlai.test.service.IFieldService;
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
public class FieldServiceImpl extends BaseService implements IFieldService {

    @Autowired
    FieldRepository fieldRepository;

    @Override
    public PageResponse<List<FieldVO>> query(Field field, PageParam pageParam) {

        Page<Field> page = fieldRepository.findAll(Example.of(field),
                new PageRequest(pageParam.getPageIndex() - 1, pageParam.getPageSize(), new Sort(Sort.Direction.DESC, "createOn")));

        List<Field> list = page.getContent();

        List<FieldVO> result = new ArrayList<>();

        for (Field item : list) {

            FieldVO fieldVO = new FieldVO();

            BeanUtils.copyProperties(item, fieldVO);

            result.add(fieldVO);
        }

        PageResponse<List<FieldVO>> response = new PageResponse<>();

        response.setTotal(page.getTotalElements());

        response.setRows(result);

        return response;
    }

    @Override
    public void create(Field field) {
        field.setCreatedBy(getUserId());
        field.setUpdatedBy(getUserId());
        field.setCreatedOn(new Date());
        field.setUpdatedOn(new Date());
        fieldRepository.save(field);
    }

    @Override
    public void modify(Field field) {
        field.setUpdatedBy(getUserId());
        field.setUpdatedOn(new Date());
        fieldRepository.save(field);
    }

    @Override
    public void deleteById(Long id) {
        fieldRepository.delete(id);
    }
}
