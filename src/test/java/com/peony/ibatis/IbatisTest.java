package com.peony.ibatis;


import com.peony.ibatis.entity.BookDO;
import com.peony.ibatis.repository.BookDAO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * MyBatis 首先会查询二级缓存。若二级缓存未命中，再去查询一级缓存
 */
import java.util.List;

@Slf4j
public class IbatisTest {


    @Test
    public void ibatisJtest(){

        SqlSession sqlSession = IbatisSource.getSqlSession();

        BookDAO bookMapper = sqlSession.getMapper(BookDAO.class);

        BookDO paramObj = BookDO.builder().name("english").build();

        List<BookDO> books = bookMapper.selectList(paramObj);

        System.out.println(books);

    }
}
