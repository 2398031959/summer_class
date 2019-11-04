package com.lv.dao;

import com.lv.po.Fack;
import com.lv.po.FackExample;
import com.lv.po.Student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface FackMapper {
    long countByExample(FackExample example);

    int deleteByExample(FackExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(Fack record);

    int insertSelective(Fack record);

    List<Fack> selectByExample(FackExample example);
    
    List<Fack> selectAllNotPass();

    Fack selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") Fack record, @Param("example") FackExample example);

    int updateByExample(@Param("record") Fack record, @Param("example") FackExample example);

    int updateByPrimaryKeySelective(Fack record);

    int updateByPrimaryKey(Fack record);

	List<Fack> facksByStudent(Student record);
}