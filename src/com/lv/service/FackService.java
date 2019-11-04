package com.lv.service;


import com.github.pagehelper.PageInfo;
import com.lv.po.Fack;
import com.lv.po.Student;

public interface FackService {
	public int insertFack(Fack fack);
	public PageInfo<Fack> listFacks(Integer fSid);
	public Fack selectFackById(Integer getfId);
	public int updateFack(Fack fack);
	public int deleteFack(Integer getfId);
	public PageInfo<Fack> listPageFacks(Integer fSid,int pageNum,int pageSize);
	public PageInfo<Fack> selectAllNotPass();
	public PageInfo<Fack> facksByStudent(Student student);
	public PageInfo<Fack> fackSkip(Student student, Integer pageNum,
			Integer pageSize);
}
