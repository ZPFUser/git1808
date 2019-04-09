package com.qianfeng.service;

import java.util.List;
import java.util.Map;

import com.qianfeng.pojo.SysSalChance;
import com.qianfeng.pojo.SysUser;

public interface SysSalChanceService {

	public Map<String, Object> findByPage(int page);
	
	public Map<String, Object> searchByRecord(int page, SysSalChance record);
	
	public void addSalChance(SysSalChance salChance, SysUser user);
 	
}
