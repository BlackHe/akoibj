package com.peony.ibatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder()
public class BookDO implements Serializable {



    private int id;

    private String name;


}
