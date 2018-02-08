package com.benlai.test.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by yaoyimin on 2018/2/5
 */
@Data
public class LabelValuePair implements Serializable {

	private String label;

	private String value;

	private static final long serialVersionUID = 1L;

	public LabelValuePair() {
	}

	public LabelValuePair setLabel(Object label) {

		if (label == null){
			this.label = "";
			return this;
		}

		this.label = label.toString();
		return this;
	}

	public LabelValuePair setValue(Object value) {

		if (value == null){
			this.value = "";
			return this;
		}

		this.value = value.toString();
		return this;
	}
}
