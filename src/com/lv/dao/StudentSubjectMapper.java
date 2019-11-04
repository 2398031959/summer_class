package com.lv.dao;

import com.lv.po.StudentSubject;
import com.lv.po.StudentSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentSubjectMapper {
    long countByExample(StudentSubjectExample example);

    int deleteByExample(StudentSubjectExample example);

    int deleteByPrimaryKey(Integer ssId);

    int insert(StudentSubject record);
    
    int insertMore(List<StudentSubject> studentSubjects);

    int insertSelective(StudentSubject record);

    List<StudentSubject> selectByExample(StudentSubjectExample example);

    StudentSubject selectByPrimaryKey(Integer ssId);

    int updateByExampleSelective(@Param("record") StudentSubject record, @Param("example") StudentSubjectExample example);

    int updateByExample(@Param("record") StudentSubject record, @Param("example") StudentSubjectExample example);

    int updateByPrimaryKeySelective(StudentSubject record);

    int updateByPrimaryKey(StudentSubject record);
}