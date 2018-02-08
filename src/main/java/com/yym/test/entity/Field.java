package com.benlai.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaoyimin on 2018/2/2
 */
@Data
@Entity
@Table(name = "field")
public class Field implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "http_id")
	private Long httpId;

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
