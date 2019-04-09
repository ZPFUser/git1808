package com.qianfeng.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.qianfeng.pojo.SysCstService;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.vo.VService;

public interface SysCstServiceService {

	public void addService(SysCstService sysCstService, SysUser user);
	
	public Map<String, Object> findByPage(int page);
	
	public Map<String, Object> searchByPage(int page, SysCstService sysCstService);
	
	public SysCstService findService(int id);
}
