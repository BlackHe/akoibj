package com.peony.ibatis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookDO implements Serializable {


    private static final long serialVersionUID = 1211561474810198962L;

    private int id;

    private String name;

    public BookDO(String name) {
        this.name = name;
    }

    public BookDO() {
    }

}
