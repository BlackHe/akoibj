package com.peony.ibatis.service;

import com.peony.ibatis.entity.ReaderDO;
import com.peony.ibatis.repository.ReaderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {


    @Autowired
    private ReaderDAO readerDAO;


    public void create(ReaderDO readerDO){
        readerDAO.insert(readerDO);
    }

}
