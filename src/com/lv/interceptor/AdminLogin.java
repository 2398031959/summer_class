package com.lv.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lv.po.Admin;



public class AdminLogin implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		HttpSession session=arg0.getSession();
		Admin admin=(Admin)session.getAttribute("admin");
		if(admin!=null){
			return true;
		}
		session.setAttribute("msg", "����δ��¼��");
		arg1.sendRedirect("toAdminLogin.action");
		return false;
	}

}
