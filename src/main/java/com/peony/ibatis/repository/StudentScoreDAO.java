package com.peony.ibatis.repository;

import com.peony.ibatis.entity.StudentScoreDO;

import java.util.List;

public interface StudentScoreDAO {

    List<StudentScoreDO> selectBy(String name,String subject);
}
