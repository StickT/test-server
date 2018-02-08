package com.benlai.test.controller.bas;

import com.benlai.test.common.base.BaseController;
import com.benlai.test.entity.HttpItem;
import com.benlai.test.service.IHttpItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yaoyimin on 2018/2/5
 */
@RequestMapping("/test/http/item")
@RestController
public class HttpItemController extends BaseController {

    @Autowired
    IHttpItemService httpItemService;

    @GetMapping("/query")
    public ResponseEntity query(HttpItem query) {
        return getSucPageData(httpItemService.query(query, getRequestPageParam()));
    }

    @PutMapping("/add")
    public ResponseEntity add(@RequestBody HttpItem httpItem) {
        httpItemService.create(httpItem);
        return OK();
    }

    @PostMapping("/modify")
    public ResponseEntity modify(@RequestBody HttpItem httpItem) {
        httpItemService.modify(httpItem);
        return OK();
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        httpItemService.deleteById(id);
        return OK();
    }
}
