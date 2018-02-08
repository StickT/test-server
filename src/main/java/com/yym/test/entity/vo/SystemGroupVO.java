package com.benlai.test.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yaoyimin on 2018/2/6
 */
@Data
public class SystemGroupVO implements Serializable {

    private Long id;

    private Long systemId;

    private String name;

    private String comments;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

}
