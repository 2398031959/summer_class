package com.lv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv.dao.ClassTypeMapper;
import com.lv.dao.EducationMapper;
import com.lv.dao.StudentClassMapper;
import com.lv.dao.SubjectMapper;
import com.lv.po.ClassType;
import com.lv.po.Education;
import com.lv.po.StudentClass;
import com.lv.po.Subject;
import com.lv.service.InitService;
@Service
public class InitServiceImpl implements InitService {
	@Autowired
	private ClassTypeMapper classTypeMapper;
	@Override
	public List<ClassType> selectClassType() {
		return classTypeMapper.selectByExample(null);
	}

	@Autowired
	private SubjectMapper subjectMapper;
	@Override
	public List<Subject> selectSubject() {
		return subjectMapper.selectByExample(null);
	}
	
	@Autowired
	private StudentClassMapper studentClassMapper;
	@Override
	public List<StudentClass> selectStudentClass() {
		return studentClassMapper.selectByExample(null);
	}
	@Resource
	private EducationMapper educationMapper;
	@Override
	public List<Education> selectEducation() {
		return educationMapper.selectByExample(null);
	}

}
