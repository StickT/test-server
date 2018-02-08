package com.benlai.test.service;

import com.benlai.test.common.page.PageParam;
import com.benlai.test.common.page.PageResponse;
import com.benlai.test.entity.HttpItem;
import com.benlai.test.entity.vo.HttpItemVO;

import java.util.List;

/**
 * Created by yaoyimin on 2018/2/5
 */
public interface IHttpItemService {

    PageResponse<List<HttpItemVO>> query(HttpItem httpItem, PageParam pageParam);

    void create(HttpItem httpItem);

    void modify(HttpItem httpItem);

    void deleteById(Long id);
}
