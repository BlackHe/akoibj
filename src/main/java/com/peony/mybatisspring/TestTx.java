package com.peony.mybatisspring;

import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.entity.ReaderDO;
import com.peony.ibatis.service.BookService;
import com.peony.ibatis.service.ProcessService;
import com.peony.mybatisspring.config.TransactionConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTx {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TransactionConfig.class);

        ProcessService processService = ac.getBean(ProcessService.class);

        processService.addedBook(new BookDO("micro service"),new ReaderDO("james"));
    }
}
