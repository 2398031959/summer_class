package com.lv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lv.po.Admin;
import com.lv.service.AdminService;
import com.lv.util.Message;

@Controller
public class AdminController {
	@Resource
	private AdminService adminService;
	/*
	 * ����Ա��¼
	 */
	@RequestMapping(value="/selectAdmin.action")
	@ResponseBody
	public Message selectAdminAction(@RequestBody Admin admin,HttpSession session){
		admin=adminService.selectAdmin(admin);
		if(admin!=null){
			session.setAttribute("admin", admin);
			return Message.success();
		}
		return Message.fail().addMap("tip","�û������������");
	}
	/*
	 * ����Ա�˳���¼
	 */
	@RequestMapping(value="/adminLogout")
	public String adminLogout(HttpSession session){
		session.removeAttribute("admin");
		return "redirect:toAdminLogin.action";
	}
}
