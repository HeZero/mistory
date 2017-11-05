package com.hsp.mistory.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Role implements Serializable {

    private Integer id;

    private String roleName;

    private String isUse;

    private Date createTime;
}