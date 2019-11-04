package com.lv.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lv.service.StudentSubjectService;
import com.lv.util.SIdAndSubIds;

@Controller
public class StudentSubjectController {
	@Autowired
	private StudentSubjectService studentSubjectService;
	/*
	 * 插入多条studentSubject
	 */
	@RequestMapping(value="/insertStudentSubject.action")
	@ResponseBody
	public int insertStudentSubjectAction(@RequestBody SIdAndSubIds sIdAndSubIds){
		int rows=studentSubjectService.insertStudentSubject(sIdAndSubIds);
		return rows;
	}
	/*
	 * 修改studentSubject
	 */
	@RequestMapping(value="/updateStudentSubject")
	@ResponseBody
	public int updateSubject(@RequestBody SIdAndSubIds sIdAndSubIds){
		int rows=studentSubjectService.updateStudentSubject(sIdAndSubIds);
		return rows;
	}
}
