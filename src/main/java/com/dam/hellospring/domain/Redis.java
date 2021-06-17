package com.dam.hellospring.domain;

public class Redis {
    private int id;
    private String key;
    private String val;

    public Redis() {
    }

    public Redis(String key, String val) {
        this.key = key;
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Redis{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
