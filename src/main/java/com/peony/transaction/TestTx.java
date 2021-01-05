package com.peony.transaction;

import com.peony.ibatis.IbatisSource;
import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.repository.BookDAO;
import com.peony.transaction.config.TransactionConfig;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;


public class TestTx {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TransactionConfig.class);

    }
}
