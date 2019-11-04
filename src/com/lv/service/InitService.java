package com.lv.service;

import java.util.List;

import com.lv.po.ClassType;
import com.lv.po.Education;
import com.lv.po.StudentClass;
import com.lv.po.Subject;

public interface InitService {
	public List<ClassType> selectClassType();
	public List<Subject> selectSubject();
	public List<StudentClass> selectStudentClass();
	public List<Education> selectEducation();
}
