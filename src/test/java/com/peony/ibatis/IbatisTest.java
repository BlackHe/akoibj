package com.peony.ibatis;


import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.entity.StudentScoreDO;
import com.peony.ibatis.repository.BookDAO;
import com.peony.ibatis.repository.BookDaoImpl;
import com.peony.ibatis.repository.StudentScoreDAO;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
public class IbatisTest {

    private static BookDAO bookDao;

    private static StudentScoreDAO studentScoreDAO;

    static {
        bookDao = new BookDaoImpl();
        studentScoreDAO = new BookDaoImpl();
    }

    @Test
    public void ibatisJtest(){
        log.info(" ===>start select");
        log.debug(" ===>start select");
        log.error(" ===>start select");
        log.trace(" ===>start select");
        log.warn(" ===>start select");
        List<StudentScoreDO> studentScoreDOS = studentScoreDAO.selectBy("M", "数学");
        System.out.println(studentScoreDOS);
    }
}
