package com.benlai.test.service.impl;

import com.benlai.test.common.base.BaseService;
import com.benlai.test.common.page.PageParam;
import com.benlai.test.common.page.PageResponse;
import com.benlai.test.entity.HttpItem;
import com.benlai.test.entity.vo.HttpItemVO;
import com.benlai.test.repository.HttpItemRepository;
import com.benlai.test.service.IHttpItemService;
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
public class HttpItemServiceImpl extends BaseService implements IHttpItemService {

    @Autowired
    HttpItemRepository httpItemRepository;

    @Override
    public PageResponse<List<HttpItemVO>> query(HttpItem httpItem, PageParam pageParam) {

        Page<HttpItem> page = httpItemRepository.findAll(Example.of(httpItem),
                new PageRequest(pageParam.getPageIndex() - 1, pageParam.getPageSize(), new Sort(Sort.Direction.DESC, "ceatedOn")));

        List<HttpItem> list = page.getContent();

        List<HttpItemVO> result = new ArrayList<>();

        for (HttpItem item : list) {

            HttpItemVO httpItemVO = new HttpItemVO();

            BeanUtils.copyProperties(item, httpItemVO);

            result.add(httpItemVO);
        }

        PageResponse<List<HttpItemVO>> pageResponse = new PageResponse<>();

        pageResponse.setRows(result);
        pageResponse.setTotal(page.getTotalElements());

        return pageResponse;
    }

    @Override
    public void create(HttpItem httpItem) {
        httpItem.setUpdatedOn(new Date());
        httpItem.setUpdatedBy(getUserId());
        httpItem.setCreatedBy(getUserId());
        httpItem.setCreatedOn(new Date());
        httpItemRepository.save(httpItem);
    }

    @Override
    public void modify(HttpItem httpItem) {
        httpItem.setUpdatedBy(getUserId());
        httpItem.setUpdatedOn(new Date());
        httpItemRepository.save(httpItem);
    }

    @Override
    public void deleteById(Long id) {
        httpItemRepository.delete(id);
    }
}
