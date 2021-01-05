package com.peony.ibatis.entity;


import java.io.Serializable;

public class BookDO implements Serializable {


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
        return "BookDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public BookDO(int id) {
        this.id = id;
    }

    public BookDO() {
    }
}
