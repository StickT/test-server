package com.benlai.test.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FieldVO implements Serializable {

    private Long id;

    private Long httpId;

    private String name;

    private Integer result;

    private String comments;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

}
