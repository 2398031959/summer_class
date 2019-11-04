package com.lv.service.impl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lv.dao.StudentMapper;
import com.lv.dao.StudentSubjectMapper;
import com.lv.po.Student;
import com.lv.po.StudentExample;
import com.lv.po.StudentSubjectExample;
import com.lv.po.StudentExample.Criteria;
import com.lv.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private StudentSubjectMapper studentSubjectMapper;
	@Override
	public int insertStudent(Student student) {
		return studentMapper.insert(student);
	}

	@Override
	public int selectsIdByNameAndPhone(Student student) {
		StudentExample studentExample = new StudentExample();
		Criteria createCriteria = studentExample.createCriteria();
		createCriteria.andSNameEqualTo(student.getsName());
		createCriteria.andSPhoneEqualTo(student.getsPhone());
		List<Student> students = studentMapper.selectByExample(studentExample);
		for (Student s : students) {
			return s.getsId();
		}
		return 0;
	}

	@Override
	public Student selectStudentByPhoneAndPwd(Student loginStudent) {
		return studentMapper.selectByPhoneAndPwd(loginStudent);
	}

	@Override
	public Student selectStudentByPhone(Student student) {
		StudentExample studentExample = new StudentExample();
		Criteria createCriteria = studentExample.createCriteria();
		createCriteria.andSPhoneEqualTo(student.getsPhone());
		List<Student> students = studentMapper.selectByExample(studentExample);
		for (Student student2 : students) {
			return student2;
		}
		return null;
	}

	@Override
	public Student selectStudentById(Student student) {
		return studentMapper.selectByPrimaryKey(student.getsId());
	}

	@Override
	public int updatePwd(Student student) {
		return studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public PageInfo<Student> selectAllStudent(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Student> students = studentMapper.selectAllStudent();
		PageInfo<Student> pageStudent = new PageInfo<Student>(students);
		return pageStudent;
	}

	@Override
	public PageInfo<Student> studentsByselectStudent(Integer pageNum,Student student) {
		PageHelper.startPage(pageNum, 5);
		List<Student> students=studentMapper.studentsByselectStudent(student);
		PageInfo<Student> pageStudent=new PageInfo<Student>(students);
		return pageStudent;
	}
	@Override
	public int updateStudent(Student student) {
		int rows=studentMapper.updateByPrimaryKeySelective(student);
		return rows;
	}
	@Override
	public int deleteStudent(Integer sId) {
		StudentSubjectExample studentSubjectExample = new StudentSubjectExample();
		com.lv.po.StudentSubjectExample.Criteria createCriteria = studentSubjectExample.createCriteria();
		createCriteria.andSIdEqualTo(sId);
		studentSubjectMapper.deleteByExample(studentSubjectExample);
		int rows=studentMapper.deleteByPrimaryKey(sId);
		return rows;
	}
}
