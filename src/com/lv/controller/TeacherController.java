package com.lv.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lv.po.Teacher;
import com.lv.service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	/*
	 * ��ʼ����ʦ�б�
	 */
	@RequestMapping(value="/listTeacherIndex")
	@ResponseBody
	public PageInfo<Teacher> listTeacherIndex(HttpServletRequest request){
		Integer pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Integer pageSize=Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<Teacher> pageTeahcer=teacherService.listTeacherIndex(pageNum, pageSize);
		return pageTeahcer;
	}
	/*
	 * �����ʦ
	 */
	@RequestMapping(value="/addTeacher")
	@ResponseBody
	public int addTeacher(Teacher teacher){
		teacher.settDate(new Date());
		int rows=teacherService.addTeacher(teacher);
		return rows;
	}
	/*
	 * ��ʦ�б��ҳ����ת
	 */
	@RequestMapping(value="/teacherSkip")
	@ResponseBody
	public PageInfo<Teacher> teacherSkip(HttpServletRequest request){
		Integer pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Integer pages=Integer.parseInt(request.getParameter("pages"));
		Integer pageSize=5;
		if(pageNum<=0){
			pageNum=1;
		}
		if(pageNum>pages){
			pageNum=pages;
		}
		String tName=request.getParameter("tName");
		Integer tEducation=Integer.parseInt(request.getParameter("tEducation"));
		String tSchool=request.getParameter("tSchool");
		Teacher teacher=new Teacher(tName, tSchool, tEducation);
		PageInfo<Teacher> pageTeacher=teacherService.teacherSkip(teacher,pageNum,pageSize);
		return pageTeacher;
	}
	/*
	 * ��ѯ������������ʦ�б�
	 */
	@RequestMapping(value="/teachersByselectTeacher")
	@ResponseBody
	public PageInfo<Teacher> teachersByselectTeacher(Teacher teacher){
		PageInfo<Teacher> pageTeacher=teacherService.teacherSkip(teacher,1,5);
		return pageTeacher;
	}
	/*
	 * ������Ҫ�޸ĵ���ʦԭ��Ϣ
	 */
	@RequestMapping(value="/updateTeacherBefore")
	@ResponseBody
	public Teacher updateTeacherBefore(@RequestBody Teacher teacher){
		teacher=teacherService.updateTeacherBefore(teacher.gettId());
		return teacher;
	}
	/*
	 * �޸���ʦ��Ϣ
	 */
	@RequestMapping(value="/updateTeacher")
	@ResponseBody
	public int updateTeacher(Teacher teacher){
		int rows=teacherService.updateTeacher(teacher);
		return rows;
	}
	/*
	 * ɾ����ʦ
	 */
	@RequestMapping(value="/deleteTeacher")
	@ResponseBody
	public int deleteTeacher(@RequestBody Teacher teacher){
		int rows=teacherService.deleteTeacher(teacher.gettId());
		return rows;
	}
}
