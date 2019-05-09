package com.intraway.fizzbuzz.entities;

public class FBError extends FizzBuzzObject{

    private Integer status;
    private String error;
    private String exception;
    private String message;
    private String path;

    public FBError(String timestamp, Integer status, String error, String exception, String message, String path) {
        super(timestamp);
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.message = message;
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}