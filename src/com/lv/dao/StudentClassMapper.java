package com.lv.dao;

import com.lv.po.StudentClass;
import com.lv.po.StudentClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentClassMapper {
    long countByExample(StudentClassExample example);

    int deleteByExample(StudentClassExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(StudentClass record);

    int insertSelective(StudentClass record);

    List<StudentClass> selectByExample(StudentClassExample example);

    StudentClass selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") StudentClass record, @Param("example") StudentClassExample example);

    int updateByExample(@Param("record") StudentClass record, @Param("example") StudentClassExample example);

    int updateByPrimaryKeySelective(StudentClass record);

    int updateByPrimaryKey(StudentClass record);
}