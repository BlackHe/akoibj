package com.peony.ibatis.repository;

import com.peony.ibatis.entity.ReaderDO;


public interface ReaderDAO {


    int insert(ReaderDO reader);

    ReaderDO select(int id);
}
