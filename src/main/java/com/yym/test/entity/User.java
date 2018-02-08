package com.benlai.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "password")
    private String password;

    @Column(name = "comments")
    private String comments;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name ="updated_on")
    private Date updatedOn;

    private static final long serialVersionUID = 1L;

}
