package com.benlai.test.service;

import com.benlai.test.common.page.PageParam;
import com.benlai.test.common.page.PageResponse;
import com.benlai.test.entity.Field;
import com.benlai.test.entity.vo.FieldVO;

import java.util.List;

/**
 * Created by yaoyimin on 2018/2/5
 */
public interface IFieldService {

    PageResponse<List<FieldVO>> query(Field field, PageParam pageParam);

    void create(Field field);

    void modify(Field field);

    void deleteById(Long id);
}
