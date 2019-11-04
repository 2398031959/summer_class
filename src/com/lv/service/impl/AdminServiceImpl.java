package com.lv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lv.dao.AdminMapper;
import com.lv.po.Admin;
import com.lv.po.AdminExample;
import com.lv.po.AdminExample.Criteria;
import com.lv.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminMapper adminMapper;
	@Override
	public Admin selectAdmin(Admin admin) {
		AdminExample adminExample = new AdminExample();
		Criteria createCriteria = adminExample.createCriteria();
		createCriteria.andAUsernameEqualTo(admin.getaUsername());
		createCriteria.andAPasswordEqualTo(admin.getaPassword());
		List<Admin> admins = adminMapper.selectByExample(adminExample);
		for (Admin admin2 : admins) {
			return admin2;
		}
		return null;
	}

}
