package com.peony.ibatis.repository;

import com.peony.ibatis.entity.BookDO;

import java.util.List;

public interface BookDAO {
    int insert(BookDO book);

    List<BookDO> selectList(BookDO bookDO);
}
