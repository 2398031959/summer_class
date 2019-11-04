package com.lv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lv.service.InitService;

@Controller
public class InitController {
	@Autowired
	private InitService initService;
	/*
	 * ����login.jsp
	 */
	@RequestMapping(value="/toLogin.action")
	public String toLoginAction(){
		return "login";
	}
	/*
	 * ����adminLogin.jsp
	 */
	@RequestMapping(value="/toAdminLogin.action")
	public String toAdminLoginAction(){
		return "adminLogin";
	}
	/*
	 * ����registerStudent.jsp
	 */
	@RequestMapping(value="/toRegisterStudent.action")
	public String toRegisterStudentAction(Model model){
		model.addAttribute("classTypes",initService.selectClassType());
		model.addAttribute("subjects", initService.selectSubject());
		model.addAttribute("clazz",initService.selectStudentClass());
		return "registerStudent";
	}
	/*
	 * ����studentMain.jsp
	 */
	@RequestMapping(value="/toMainStudent")
	public String toMainStudent(){
		return "studentMain";
	}
	/*
	 * ����mainAdmin.jsp
	 */
	@RequestMapping(value="/toMainAdmin")
	public String toMainAdmin(Model model){
		model.addAttribute("classTypes",initService.selectClassType());
		model.addAttribute("clazz",initService.selectStudentClass());
		model.addAttribute("subjects", initService.selectSubject());
		model.addAttribute("educations", initService.selectEducation());
		return "mainAdmin";
	}
}
