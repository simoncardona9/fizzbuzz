package com.intraway.fizzbuzz.entities;

public class ListaNumero extends FizzBuzzObject {

    private String code;
    private String description;
    private String list;

    public ListaNumero(String timestamp, String code, String description, String list) {
        super(timestamp);
        this.code = code;
        this.description = description;
        this.list = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
