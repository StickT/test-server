package com.benlai.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaoyimin on 2018/2/1
 */
@Entity
@Table(name = "system_group")
@Data
public class SystemGroup implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "system_id")
	private Long systemId;

	@Column(name = "name")
	private String name;

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
