package com.hsp.mistory.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Log implements Serializable{

    private Integer id;

    private Integer type;

    private String content;

    private Integer userId;

    private Date createTime;
}