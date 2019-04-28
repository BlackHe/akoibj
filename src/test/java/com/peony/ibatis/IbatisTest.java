package com.peony.ibatis;


import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.repository.BookDAO;
import com.peony.ibatis.repository.BookDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class IbatisTest {

    private static BookDAO bookDao;

    static {
        bookDao = new BookDaoImpl();
    }

    @Test
    public void ibatisJtest(){
//        bookDao.insert(new BookDO("I have a dream"));
        bookDao.selectList(new BookDO("I have a dream"));
    }
}
