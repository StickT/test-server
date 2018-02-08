package com.benlai.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaoyimin on 2018/2/1
 */
@Table(name = "http_item")
@Entity
@Data
public class HttpItem implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "system_id")
	private Long systemId;

	@Column(name = "group_id")
	private Long groupId;

	@Column(name = "url")
	private String url;

	@Column(name = "type")
	private Integer type;

	@Column(name = "need_token")
	private Integer needToken;

	@Column(name = "path_param")
	private String pathParam;

	@Column(name = "header")
	private String header;

	@Column(name = "body")
	private String body;

	@Column(name = "name")
	private String name;

	@Column(name = "result")
	private Integer result;

	@Column(name = "comments")
	private String comments;

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
