package com.benlai.test.controller.bas;

import com.benlai.test.common.base.BaseController;
import com.benlai.test.entity.System;
import com.benlai.test.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yaoyimin on 2018/2/5
 */
@RequestMapping("/test/system")
@RestController
public class SystemController extends BaseController {

	@Autowired
	ISystemService systemService;

	@GetMapping("/query")
	public ResponseEntity query(System query){
		return getSucPageData(systemService.query(query,getRequestPageParam()));
	}

	@PutMapping("/add")
	public ResponseEntity add(@RequestBody System system){
		systemService.create(system);
		return OK();
	}

	@PostMapping("/modify")
	public ResponseEntity modify(@RequestBody System system){
		systemService.modify(system);
		return OK();
	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity delete(@PathVariable Long id){
		systemService.deleteById(id);
		return OK();
	}

}
