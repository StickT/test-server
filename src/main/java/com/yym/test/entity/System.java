package com.benlai.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaoyimin on 2018/2/1
 */
@Table(name = "system")
@Entity
@Data
public class System implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "env")
	private Integer env;

	@Column(name = "basic_url")
	private String basicUrl;

	@Column(name = "login_url")
	private String loginUrl;

	@Column(name = "login_type")
	private Integer loginType;

	@Column(name = "login_user")
	private String loginUser;

	@Column(name = "login_password")
	private String loginPassword;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_on")
	private Date updatedOn;

	private static final long serialVersionUID = 1L;

}
