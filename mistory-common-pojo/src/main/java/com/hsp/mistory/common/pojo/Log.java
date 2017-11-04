package com.hsp.mistory.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class Log implements Serializable{
    private Integer id;

    private Integer type;

    private String content;

    private Integer userId;

    private Date createTime;


}