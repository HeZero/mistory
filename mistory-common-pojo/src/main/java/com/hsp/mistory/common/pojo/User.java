package com.hsp.mistory.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class User implements Serializable{

    private Integer id;

    private String username;

    private String password;

    private String identityNo;

    private String phone;

    private String email;

    private Date loginTime;

    private String isUse;

    private String status;

    private Date createTime;

    private Date updateTime;

}