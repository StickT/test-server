package com.benlai.test.entity.vo;

import com.benlai.test.entity.ems.EnvEnum;
import com.benlai.test.entity.ems.HttpTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yaoyimin on 2018/2/5
 */
@Data
public class SystemVO implements Serializable {

	private Long id;

	private String name;

	private Integer env;

	private String envDesc;

	private String basicUrl;

	private String loginUrl;

	private Integer loginType;

	private String loginTypeDesc;

	private String loginUser;

	private String loginPassword;

	private String createdBy;

	private Date createdOn;

	private String createdOnDesc;

	private String updatedBy;

	private Date updatedOn;

	private String updatedOnDesc;

	private static final long serialVersionUID = 1L;

	public String getEnvDesc() {

		EnvEnum envEnum = EnvEnum.getByCode(this.env);

		if (envEnum == null){
			return "";
		}

		return envEnum.getDesc();
	}

	public String getLoginTypeDesc() {

		if (this.loginType == null){
			return "";
		}

		HttpTypeEnum typeEnum = HttpTypeEnum.getByCode(this.loginType);

		if (typeEnum == null){
			return "";
		}

		return typeEnum.getDesc();
	}

	public String getCreatedOnDesc() {


		if (this.createdOn == null){
			return "";
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

		return dateFormat.format(this.createdOn);
	}

	public String getUpdatedOnDesc() {

		if (this.updatedOn == null){
			return "";
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

		return dateFormat.format(this.updatedOn);
	}
}
