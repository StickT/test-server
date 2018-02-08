package com.benlai.test.controller.bas;

import com.benlai.test.common.base.BaseController;
import com.benlai.test.entity.Field;
import com.benlai.test.service.IFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yaoyimin on 2018/2/5
 */
@RequestMapping("/test/field")
@RestController
public class FieldController extends BaseController {

    @Autowired
    IFieldService fieldService;

    @GetMapping("/query")
    public ResponseEntity query(Field query) {
        return getSucPageData(fieldService.query(query, getRequestPageParam()));
    }

    @PutMapping("/add")
    public ResponseEntity add(@RequestBody Field field) {
        fieldService.create(field);
        return OK();
    }

    @PostMapping("/modify")
    public ResponseEntity modify(@RequestBody Field field) {
        fieldService.modify(field);
        return OK();
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        fieldService.deleteById(id);
        return OK();
    }
}
