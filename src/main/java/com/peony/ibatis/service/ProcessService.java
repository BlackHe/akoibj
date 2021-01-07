package com.peony.ibatis.service;

import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.entity.ReaderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcessService {

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;


//    @Transactional
    public void addedBook(BookDO bookDO, ReaderDO readerDO){
        bookService.create(bookDO);
        readerService.create(readerDO);
    }


}
