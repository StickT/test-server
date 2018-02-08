package com.benlai.test.controller;

import com.benlai.test.common.base.BaseController;
import com.benlai.test.common.entity.LabelValuePair;
import com.benlai.test.entity.ems.EnvEnum;
import com.benlai.test.entity.ems.HttpTypeEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaoyimin on 2018/2/5
 */
@RequestMapping("/test/dict")
@RestController
public class DictController extends BaseController{

	@GetMapping("/env/get/all")
	public ResponseEntity getEnvList(){

		List<LabelValuePair> list = new ArrayList<>();

		Arrays.stream(EnvEnum.values()).forEach(x->{
			LabelValuePair labelValuePair = new LabelValuePair();

			labelValuePair.setLabel(x.getDesc());
			labelValuePair.setValue(x.getCode());

			list.add(labelValuePair);
		});

		return OK(list);
	}

	@GetMapping("/http-type/get/all")
	public ResponseEntity getHttpTypeList(){
		List<LabelValuePair> list = new ArrayList<>();

		Arrays.stream(HttpTypeEnum.values()).forEach(x->{
			LabelValuePair labelValuePair = new LabelValuePair();

			labelValuePair.setLabel(x.getDesc());
			labelValuePair.setValue(x.getCode());

			list.add(labelValuePair);
		});

		return OK(list);
	}
}
