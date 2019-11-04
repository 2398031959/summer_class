package com.lv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lv.dao.FackMapper;
import com.lv.po.Fack;
import com.lv.po.FackExample;
import com.lv.po.Student;
import com.lv.po.FackExample.Criteria;
import com.lv.service.FackService;
@Service
public class FackServiceImpl implements FackService {
	@Autowired
	private FackMapper fackMapper;
	
	@Override
	public int insertFack(Fack fack) {
		return fackMapper.insertSelective(fack);
	}
	@Override
	public PageInfo<Fack> listFacks(Integer fSid) {
		FackExample fackExample = new FackExample();
		Criteria createCriteria = fackExample.createCriteria();
		createCriteria.andFSidEqualTo(fSid);
		PageHelper.startPage(1, 5);
		List<Fack> facks=fackMapper.selectByExample(fackExample);
		PageInfo<Fack> pageInfo=new PageInfo<Fack>(facks);
		return pageInfo;
	}
	@Override
	public Fack selectFackById(Integer getfId) {
		return fackMapper.selectByPrimaryKey(getfId);
	}
	@Override
	public int updateFack(Fack fack) {
		return fackMapper.updateByPrimaryKeySelective(fack);
	}
	@Override
	public int deleteFack(Integer getfId) {
		return fackMapper.deleteByPrimaryKey(getfId);
	}
	@Override
	public PageInfo<Fack> listPageFacks(Integer fSid, int pageNum, int pageSize) {
		FackExample fackExample = new FackExample();
		Criteria createCriteria = fackExample.createCriteria();
		createCriteria.andFSidEqualTo(fSid);
		fackExample.setOrderByClause("f_id desc");
		PageHelper.startPage(pageNum, pageSize);
		List<Fack> facks=fackMapper.selectByExample(fackExample);
		PageInfo<Fack> pageInfo=new PageInfo<Fack>(facks);
		return pageInfo;
	}
	@Override
	public PageInfo<Fack> selectAllNotPass() {
		PageHelper.startPage(1, 5);
		List<Fack> facks=fackMapper.selectAllNotPass();
		PageInfo<Fack> fackPage=new PageInfo<Fack>(facks);
		return fackPage;
	}
	@Override
	public PageInfo<Fack> facksByStudent(Student student) {
		PageHelper.startPage(1,5);
		List<Fack> facks=fackMapper.facksByStudent(student);
		PageInfo<Fack> fackPage=new PageInfo<Fack>(facks);
		return fackPage;
	}
	@Override
	public PageInfo<Fack> fackSkip(Student student, Integer pageNum,
			Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Fack> facks=fackMapper.facksByStudent(student);
		PageInfo<Fack> fackPage=new PageInfo<Fack>(facks);
		return fackPage;
	}
}
