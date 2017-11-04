package com.hsp.exception;

/**
 * 基础业务类
 * Created by hsp on 2017/11/4.
 */
public class BaseBusisException extends RuntimeException{

    //错误代码
    protected int code;
    //异常信息
    protected String msg;

    public BaseBusisException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseBusisException() {
        super();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
