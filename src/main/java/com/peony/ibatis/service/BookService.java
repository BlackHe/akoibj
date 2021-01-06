package com.peony.ibatis.service;

import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.entity.ReaderDO;
import com.peony.ibatis.repository.BookDAO;
import com.peony.ibatis.repository.ReaderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;




    public void create(BookDO bookDO){
        bookDAO.insert(bookDO);
    }

}
