package com.peony.ibatis.repository;

import com.peony.ibatis.entity.BookDO;


public interface BookDAO {


    int insert(BookDO book);

    BookDO select(int id);
}
