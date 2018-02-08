package com.benlai.test.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HttpItemVO implements Serializable {

    private Long id;

    private Long systemId;

    private Long groupId;

    private String url;

    private Integer type;

    private Integer needToken;

    private String pathParam;

    private String header;

    private String body;

    private String name;

    private Integer result;

    private String comments;

    private String createdBy;

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;

}
