package com.benlai.test.controller.bas;

import com.benlai.test.common.base.BaseController;
import com.benlai.test.entity.SystemGroup;
import com.benlai.test.service.ISystemGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yaoyimin on 2018/2/5
 */
@RequestMapping("/test/group")
@RestController
public class SystemGroupController extends BaseController {

	@Autowired
	ISystemGroupService groupService;

	@GetMapping("/query")
	public ResponseEntity query(SystemGroup systemGroup){
		return getSucPageData(groupService.query(systemGroup, getRequestPageParam()));
	}

	@PutMapping("/add")
	public ResponseEntity add(@RequestBody SystemGroup systemGroup){
		groupService.create(systemGroup);
		return OK();
	}

	@PostMapping("/save")
	public ResponseEntity modify(@RequestBody SystemGroup systemGroup){
		groupService.modify(systemGroup);
		return OK();
	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity delete(@PathVariable Long id){
		groupService.deleteById(id);
		return OK();
	}

}
