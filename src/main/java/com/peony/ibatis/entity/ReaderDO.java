package com.peony.ibatis.entity;


import java.io.Serializable;

public class ReaderDO implements Serializable {


    private int id;

    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public ReaderDO(int id) {
        this.id = id;
    }


    public ReaderDO(String name) {
        this.name = name;
    }

    public ReaderDO() {
    }
}
