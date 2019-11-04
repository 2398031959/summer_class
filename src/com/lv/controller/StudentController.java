package com.lv.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lv.po.Student;
import com.lv.service.InitService;
import com.lv.service.StudentService;
import com.lv.util.Message;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private InitService initService;
	/*
	 *���ѧ��
	 */
	@RequestMapping(value="/insertStudent.action")
	@ResponseBody
	public Message insertStudent(@RequestBody Student student){
		String sName=student.getsName();
		String sSex=student.getsSex();
		String sPhone=student.getsPhone();
		String sAddress=student.getsAddress();
		if("".equals(sName)||"".equals(sPhone)||"".equals(sAddress)||sSex==null){
			return Message.fail().addMap("nullTip", "��Ϣ��д��ȫ������д����");
		}else{
			if(studentService.selectStudentByPhone(student)==null){
				student.setsDate(new Date());
				student.setsPwd("000000");
				int rows=studentService.insertStudent(student);
				return Message.success().addMap("rows", rows);
			}else{
				return Message.fail().addMap("phoneTip", "���ֻ�����ע�ᣬ��ѡ�������ֻ��ţ�");
			}
		}
	}
	/*
	 * ͨ���������ֻ��Ų���ѧ����Id
	 */
	@RequestMapping(value="/selectsIdByNameAndPhone.action")
	@ResponseBody
	public int selectsIdByNameAndPhoneAction(@RequestBody Student student){
		int sId=studentService.selectsIdByNameAndPhone(student);
		return sId;
	}
	
	/*
	 *ͨ���ֻ��ź��������ѧ����ʵ�ֵ�¼
	 */
	@RequestMapping(value="/selectStudentByPhoneAndPwd.action")
	@ResponseBody
	public Message selectStudentByPhoneAndPwdAction(@RequestBody Student loginStudent,HttpSession session){
		Student student=studentService.selectStudentByPhoneAndPwd(loginStudent);
		if(student!=null){
			session.setAttribute("student", student);
			return Message.success();
		}else{
			return Message.fail().addMap("tip", "�û������������");
		}
	}
	/*
	 * �˳���¼
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute("student");
		return "redirect:toLogin.action";
	}
	/*
	 * �޸����� ��һ�������������Ƿ�������ȷ
	 */
	@RequestMapping(value="/checkOldPwd")
	@ResponseBody
	public Message checkOldPwd(@RequestBody Student student){
		String sPwd=student.getsPwd();
		student=studentService.selectStudentById(student);
		if(student.getsPwd().equals(sPwd)){
			return Message.success();
		}else{
			return Message.fail().addMap("errorTip", "��������������");
		}
	}
	/*
	 * �޸����� �ڶ�����������������ȷ����������
	 */
	@RequestMapping(value="updatePwd")
	@ResponseBody
	public Message updatePwd(@RequestBody Student student){
		String sPwd=student.getsPwd();
		if(sPwd.trim().length()!=0){
				studentService.updatePwd(student);
				return Message.success();
		}else{
			return Message.fail().addMap("errorTip","�����벻��Ϊ��");
		}
	}
	
	/*
	 * ��������ѯ��ҳ��ѧ��
	 */
	@RequestMapping(value="/selectAllStudent")
	@ResponseBody
	public PageInfo<Student> selectAllStudent(HttpServletRequest request,Model model){
		Integer pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Integer pageSize=Integer.parseInt(request.getParameter("pageSize"));
		PageInfo<Student> pageStudent=studentService.selectAllStudent(pageNum,pageSize);
		return pageStudent;
	}
	/*
	 * ��������ѯ��ҳѧ��
	 */
	@RequestMapping(value="/studentsByselectStudent")
	@ResponseBody
	public PageInfo<Student> studentsByselectStudent(HttpServletRequest request){
		Integer pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Integer sClasstype=Integer.parseInt(request.getParameter("sClasstype"));
		Integer sClass=Integer.parseInt(request.getParameter("sClass"));
		String sName=request.getParameter("sName");
		Student student=new Student(sName, sClass, sClasstype);
		PageInfo<Student> pageStudent=studentService.studentsByselectStudent(pageNum,student);
		return pageStudent;
	}
	/*
	 * ѧ���б��ҳ����ת
	 */
	@RequestMapping(value="/studentSkip")
	@ResponseBody
	public PageInfo<Student> studentSkip(HttpServletRequest request){
		Integer pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Integer pages=Integer.parseInt(request.getParameter("pages"));
		if(pageNum>pages){
			pageNum=pages;
		}
		if(pageNum<=0){
			pageNum=1;
		}
		Integer sClasstype=Integer.parseInt(request.getParameter("sClasstype"));
		Integer sClass=Integer.parseInt(request.getParameter("sClass"));
		String sName=request.getParameter("sName");
		Student student=new Student(sName, sClass, sClasstype);
		PageInfo<Student> pageStudent=studentService.studentsByselectStudent(pageNum,student);
		return pageStudent;
	}
	/*
	 * �鿴��Ҫ����ѧ����ԭ��Ϣ
	 */
	@RequestMapping(value="/updateBefore")
	@ResponseBody
	public Student updateBefore(@RequestBody Student student,HttpSession session){
		return studentService.selectStudentByPhoneAndPwd(student);
	}
	/*
	 * ����ѧ������Ϣ
	 */
	@RequestMapping(value="/updateStudent")
	@ResponseBody
	public Message updateBefore(@RequestBody Student student){
		int rows=studentService.updateStudent(student);
		return Message.success().addMap("rows", rows);
	}
	@RequestMapping(value="deleteStudent")
	@ResponseBody
	public int deleteStudent(@RequestBody Student student){
		int rows=studentService.deleteStudent(student.getsId());
		return rows;
	}
	
}
