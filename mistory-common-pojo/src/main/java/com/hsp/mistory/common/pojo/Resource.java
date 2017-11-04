package com.hsp.mistory.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Resource implements Serializable{

    private Integer id;

    private Boolean type;

    private String name;

    private String url;

    private String permission;

    private Date createTime;

    private String isUse;

}