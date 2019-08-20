package com.peony.ibatis.repository;

import com.peony.ibatis.entity.BookDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static com.peony.utils.PrintUtils.*;

public class BookDaoImpl implements BookDAO {

    private static SqlSessionFactory sqlSessionFactory;

    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            print(e.toString());
        }
    }

    public int insert(BookDO book) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookDAO mapper = sqlSession.getMapper(BookDAO.class);
        try {
            return mapper.insert(book);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    public List<BookDO> selectList(BookDO bookDO) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookDAO mapper = sqlSession.getMapper(BookDAO.class);
        try {
            return mapper.selectList(bookDO);
        }finally {
            sqlSession.close();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
