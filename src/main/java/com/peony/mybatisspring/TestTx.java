package com.peony.mybatisspring;

import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.entity.ReaderDO;
import com.peony.ibatis.repository.BookDAO;
import com.peony.ibatis.service.BookService;
import com.peony.ibatis.service.ProcessService;
import com.peony.mybatisspring.config.TransactionConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

public class TestTx {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TransactionConfig.class);

//        BookService bookService = ac.getBean(BookService.class);
//        BookDO bookDO = new BookDO();
//        for (int i = 0; i < 3000000; i++) {
//            bookDO.setName(UUID.randomUUID().toString().replace("-", ""));
//            bookDO.setAuthor(UUID.randomUUID().toString().substring(0,10));
//            bookDO.setDesc(UUID.randomUUID().toString().replace("-", "") + UUID.randomUUID().toString().replace("-", ""));
//            bookDO.setIsbn(UUID.randomUUID().toString().substring(0, 16));
//            bookService.create(bookDO);
//        }

//        ProcessService processService = ac.getBean(ProcessService.class);
//        processService.addedBook(new BookDO("micro service"),new ReaderDO("james"));
//        processService.remove(new BookDO("micro service"));
//
//        BookDAO bookDAO = ac.getBean(BookDAO.class);
//        System.out.println(bookDAO.select(1));
//        System.out.println(bookDAO.select(2));
//        System.out.println(bookDAO.select(3));
    }
}
