package com.xnote.client.common.bean;


public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
        this.code = 0;
        this.message = "操作成功！";
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(String message, T data) {
        this.code = 0;
        this.message = message;
        this.data = data;
    }
    /////////////////////////////////////////////////////////////////////
    public Result success()
    {
        this.code = 0;
        this.message = "";
        return this;
    }

    public Result success(String message)
    {
        this.code = 0;
        this.message = message;
        return this;
    }

    public Result success(T data)
    {
        this.code = 0;
        this.message = "操作成功！";
        this.data = data;
        return this;
    }

    public Result success(Integer code, String message)
    {
        this.code = code;
        this.message = message;
        return this;
    }

    public Result success(String message, T data)
    {
        this.code = 0;
        this.message = message;
        this.data = data;
        return this;
    }

    public Result success(Integer code, String message, T data)
    {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }
    /////////////////////////////////////////////////////////////////////
    public Result failed()
    {
        this.code = 1;
        this.message = "操作成功！";
        return this;
    }

    public Result failed(String message)
    {
        this.code = 1;
        this.message = message;
        return this;
    }

    public Result failed(T data)
    {
        this.code = 1;
        this.message = "操作成功！";
        this.data = data;
        return this;
    }

    public Result failed(Integer code, String message)
    {
        this.code = code;
        this.message = message;
        return this;
    }

    public Result failed(String message, T data)
    {
        this.code = 1;
        this.message = message;
        this.data = data;
        return this;
    }

    public Result failed(Integer code, String message, T data)
    {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }
    /////////////////////////////////////////////////////////////////////
    public Result error()
    {
        this.code = -1;
        this.message = "操作成功！";
        return this;
    }

    public Result error(String message)
    {
        this.code = -1;
        this.message = message;
        return this;
    }

    public Result error(T data)
    {
        this.code = -1;
        this.message = "操作成功！";
        this.data = data;
        return this;
    }

    public Result error(Integer code, String message)
    {
        this.code = code;
        this.message = message;
        return this;
    }

    public Result error(String message, T data)
    {
        this.code = -1;
        this.message = message;
        this.data = data;
        return this;
    }

    public Result error(Integer code, String message, T data)
    {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }
}
