package com.qianfeng.service;

import java.util.List;
import java.util.Map;

import com.qianfeng.pojo.SysUser;

public interface SysUserService {

	public SysUser login(String name, String password);
	
	public Map<String, Object> findByPage(int page);
	
	public void addUser(SysUser user);
	
	public void delectUserByUid(int id);
	
	public void addMultiUser(List<SysUser> list);
	
	public List<SysUser> findManager();
}
