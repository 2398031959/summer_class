package com.lv.service;

import com.github.pagehelper.PageInfo;
import com.lv.po.Teacher;

public interface TeacherService {
	public PageInfo<Teacher> listTeacherIndex(Integer pageNum,Integer pageSize);
	public int addTeacher(Teacher teacher);
	public PageInfo<Teacher> teacherSkip(Teacher teacher, Integer pageNum,
			Integer pageSize);
	public Teacher updateTeacherBefore(Integer gettId);
	public int updateTeacher(Teacher teacher);
	public int deleteTeacher(Integer gettId);
}
