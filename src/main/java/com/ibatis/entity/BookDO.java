package com.peony.ibatis.entity;

import lombok.Data;

@Data
public class BookDO {

    private int id;

    private String name;

    public BookDO(String name) {
        this.name = name;
    }

    public BookDO() {
    }
}
