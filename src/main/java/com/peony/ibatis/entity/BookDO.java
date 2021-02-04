package com.peony.ibatis.entity;


import java.io.Serializable;

public class BookDO implements Serializable {


    private int id;

    private String name;

    private String author;

    private String isbn;

    private String desc;



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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookDO(int id) {
        this.id = id;
    }


    public BookDO(String name) {
        this.name = name;
    }

    public BookDO() {
    }
}
