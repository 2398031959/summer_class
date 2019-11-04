package com.lv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lv.dao.TeacherMapper;
import com.lv.po.Teacher;
import com.lv.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;
	@Override
	public PageInfo<Teacher> listTeacherIndex(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Teacher> teachers=teacherMapper.listTeacherIndex();
		PageInfo<Teacher> pageTeacher=new PageInfo<Teacher>(teachers);
		return pageTeacher;
	}
	@Override
	public int addTeacher(Teacher teacher) {
		return teacherMapper.insertSelective(teacher);
	}
	@Override
	public PageInfo<Teacher> teacherSkip(Teacher teacher, Integer pageNum,
			Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Teacher> teachers=teacherMapper.teacherSkip(teacher);
		PageInfo<Teacher> pageTeacher=new PageInfo<Teacher>(teachers);
		return pageTeacher;
	}
	@Override
	public Teacher updateTeacherBefore(Integer gettId) {
		return teacherMapper.selectByPrimaryKey(gettId);
	}
	@Override
	public int updateTeacher(Teacher teacher) {
		return teacherMapper.updateByPrimaryKeySelective(teacher);
	}
	@Override
	public int deleteTeacher(Integer gettId) {
		return teacherMapper.deleteByPrimaryKey(gettId);
	}
}
