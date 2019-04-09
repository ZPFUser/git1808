package com.qianfeng.service;

import java.util.List;
import java.util.Map;

import com.qianfeng.pojo.SysBasDict;

public interface SysBasDictService {

	public Map<String, Object> findByPage(int page);
	
	public void addDict(SysBasDict basDict);
	
	public Map<String, Object> searchByRecord(int page, SysBasDict basDict);
	
	public void delectDict(int id);
	
	public SysBasDict findDictById(int id);
	
	public void modifyDict(SysBasDict basDict);
	
	public List<SysBasDict> findSerType();
}
