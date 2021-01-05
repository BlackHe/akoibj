package com.peony.mybatisspring;

import com.peony.ibatis.repository.BookDAO;
import com.peony.mybatisspring.config.TransactionConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTx {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TransactionConfig.class);
        BookDAO BookDao = ac.getBean(BookDAO.class);

        System.out.println(BookDao.select(1));

        System.out.println(BookDao.select(2));
    }
}
