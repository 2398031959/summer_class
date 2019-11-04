package com.lv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv.dao.StudentSubjectMapper;
import com.lv.po.StudentSubject;
import com.lv.po.StudentSubjectExample;
import com.lv.po.StudentSubjectExample.Criteria;
import com.lv.service.StudentSubjectService;
import com.lv.util.SIdAndSubIds;
@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {
	@Autowired
	private StudentSubjectMapper studentSubjectMapper;
	
	@Override
	public int insertStudentSubject(SIdAndSubIds sIdAndSubIds) {
		Integer[] subIds=sIdAndSubIds.getSubIds();
		Integer sId=sIdAndSubIds.getsId();
		List<StudentSubject> studentSubjects=new ArrayList<StudentSubject>();
		StudentSubject studentSubject=null;
		for(int i=0;i<subIds.length;i++){
			studentSubject=new StudentSubject(sId, subIds[i]);
			studentSubjects.add(studentSubject);
		}
		int rows=studentSubjectMapper.insertMore(studentSubjects);
		return rows;
	}
	@Override
	public int updateStudentSubject(SIdAndSubIds sIdAndSubIds) {
		Integer[] subIds=sIdAndSubIds.getSubIds();
		Integer sId=sIdAndSubIds.getsId();
		StudentSubjectExample studentSubjectExample = new StudentSubjectExample();
		Criteria createCriteria = studentSubjectExample.createCriteria();
		createCriteria.andSIdEqualTo(sId);
		studentSubjectMapper.deleteByExample(studentSubjectExample);
		List<StudentSubject> studentSubjects=new ArrayList<StudentSubject>();
		StudentSubject studentSubject=null;
		for(int i=0;i<subIds.length;i++){
			studentSubject=new StudentSubject(sId, subIds[i]);
			studentSubjects.add(studentSubject);
		}
		int rows=studentSubjectMapper.insertMore(studentSubjects);
		return rows;
	}
}
