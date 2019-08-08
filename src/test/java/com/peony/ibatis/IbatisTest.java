package com.peony.ibatis;


import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.repository.BookDAO;
import com.peony.ibatis.repository.BookDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * MyBatis 首先会查询二级缓存。若二级缓存未命中，再去查询一级缓存
 */
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
        List<BookDO> bookDOList = bookDao.selectList(new BookDO("I have a dream"));
        System.out.println(bookDOList);
    }
}
