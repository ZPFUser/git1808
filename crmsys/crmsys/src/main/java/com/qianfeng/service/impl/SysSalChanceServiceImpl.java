package com.qianfeng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.SysSalChanceMapper;
import com.qianfeng.pojo.SysSalChance;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysSalChanceService;

@Service
public class SysSalChanceServiceImpl implements SysSalChanceService{

	@Autowired
	private SysSalChanceMapper salChanceDao;
	
	
	@Override
	public Map<String, Object> findByPage(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		//list得到的是分页后的数据
		List<SysSalChance> list = salChanceDao.selectAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());//总记录个数
		map.put("rows", list);//分页的数据
		
		return map;
	}


	@Override
	public Map<String, Object> searchByRecord(int page, SysSalChance record) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		//list得到的是分页后的数据
		List<SysSalChance> list = salChanceDao.selectByRecord(record);
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());//总记录个数
		map.put("rows", list);//分页的数据
		
		return map;
	
	}


	@Override
	public void addSalChance(SysSalChance salChance, SysUser user) {
		// TODO Auto-generated method stub
		salChance.setChcStatus(2);
		salChance.setChcFlag(0);
		salChance.setChcCreateId(user.getUsrId());
		salChanceDao.insertSelective(salChance);
		
	}


	


	

}
