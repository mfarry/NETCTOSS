package com.lanou.utils;

/**
 * Created by dllo on 17/10/10.
 */
public class AjaxResult {
    private String message;
    private Integer errorCode;
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public AjaxResult() {
    }

    public AjaxResult(Object data) {
        this.message = "成功";
        this.errorCode=0;
        this.data=data;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                ", data=" + data +
                '}';
    }
}
