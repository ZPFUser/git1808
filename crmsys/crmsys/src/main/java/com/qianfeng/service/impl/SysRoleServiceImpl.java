package com.qianfeng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.SysRoleMapper;
import com.qianfeng.pojo.SysRole;
import com.qianfeng.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleMapper roleDao;
	
	@Override
	public List<SysRole> findAllRole() {
		// TODO Auto-generated method stub
	    return roleDao.selectAll();
	}

}
