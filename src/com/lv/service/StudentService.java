package com.lv.service;


import com.github.pagehelper.PageInfo;
import com.lv.po.Student;

public interface StudentService {
	public int insertStudent(Student student);
	public int selectsIdByNameAndPhone(Student student);
	public Student selectStudentByPhoneAndPwd(Student loginStudent);
	public Student selectStudentByPhone(Student student);
	public Student selectStudentById(Student student);
	public int updatePwd(Student student);
	public PageInfo<Student> selectAllStudent(Integer pageNum, Integer pageSize);
	public PageInfo<Student> studentsByselectStudent(Integer pageNum,Student student);
	public int updateStudent(Student student);
	public int deleteStudent(Integer sId);
}
