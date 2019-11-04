package com.lv.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lv.po.Fack;
import com.lv.po.Student;
import com.lv.service.FackService;
import com.lv.util.Message;

@Controller
public class FackController {
	@Resource
	private FackService fackService;
	/*
	 * 添加假期
	 */
	@RequestMapping(value="/insertFack")
	@ResponseBody
	public int insertFack(@RequestBody Fack fack){
		int rows=fackService.insertFack(fack);
		return rows;
	}
	
	/*
	 * 通过主键查询假条
	 */
	@RequestMapping(value="/selectFackById")
	@ResponseBody
	public Fack selectFackById(@RequestBody Fack fack){
		fack=fackService.selectFackById(fack.getfId());
		return fack;
	}
	/*
	 * 修改假条
	 */
	@RequestMapping(value="/updateFack")
	@ResponseBody
	public int updateFack(@RequestBody Fack fack){
		int rows=fackService.updateFack(fack);
		return rows;
	}
	/*
	 * 删除假条
	 */
	@RequestMapping(value="/deleteFack")
	@ResponseBody
	public int deleteFack(@RequestBody Fack fack){
		int rows=fackService.deleteFack(fack.getfId());
		return rows;
	}
	/*
	 * 确定pageNum和pages的值，session储存，分页调用
	 */
	@RequestMapping(value="/saveOwnPage")
	@ResponseBody
	public int saveOwnPage(@RequestBody PageInfo<Fack> pageInfo,HttpSession session){
		if(pageInfo.getPageNum()<=0){
			pageInfo.setPageNum(1);
		}else if(pageInfo.getPageNum()>pageInfo.getPages()){
			pageInfo.setPageNum(pageInfo.getPages());
		}
		session.setAttribute("pageInfo", pageInfo);
		return 1;
	}
	/*
	 * 列出分页内容
	 */
	@RequestMapping(value="/listPageFacks")
	@ResponseBody
	public Message listPageFacks(@RequestBody Fack fack,HttpSession session){
		@SuppressWarnings("unchecked")
		PageInfo<Fack> pageInfo=(PageInfo<Fack>)session.getAttribute("pageInfo");
		int pageNum=pageInfo.getPageNum();
		int pageSize=pageInfo.getPageSize();
		Integer fSid=fack.getfSid();
		pageInfo=fackService.listPageFacks(fSid,pageNum,pageSize);
		return Message.success().addMap("pageInfo", pageInfo);
	}
	@RequestMapping(value="/selectAllNotPass")
	@ResponseBody
	public PageInfo<Fack> selectAllNotPass(){
		PageInfo<Fack> fackPage = fackService.selectAllNotPass();
		return fackPage;
	}
	@RequestMapping(value="/facksByStudent")
	@ResponseBody
	public PageInfo<Fack> facksByStudent(Student student){
		PageInfo<Fack> fackPage=fackService.facksByStudent(student);
		return fackPage;
	}
	
	@RequestMapping(value="/fackSkip")
	@ResponseBody
	public PageInfo<Fack> fackSkip(HttpServletRequest request){
		String sName = request.getParameter("sName");
		Integer sClass=Integer.parseInt(request.getParameter("sClass"));
		Integer sClasstype=Integer.parseInt(request.getParameter("sClasstype"));
		Integer pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Integer pages=Integer.parseInt(request.getParameter("pages"));
		Student student=new Student(sName, sClass, sClasstype);
		if(pageNum<=0){
			pageNum=1;
		}
		if(pageNum>pages){
			pageNum=pages;
		}
		Integer pageSize=5;
		PageInfo<Fack> fackPage=fackService.fackSkip(student,pageNum,pageSize);
		return fackPage;
	}
	@RequestMapping(value="/changeFack")
	@ResponseBody
	public int changeFack(@RequestBody Fack fack){
		int rows=fackService.updateFack(fack);
		return rows;
	}
}
