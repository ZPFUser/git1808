package com.qianfeng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.SysCstServiceMapper;
import com.qianfeng.pojo.SysCstService;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysCstServiceService;
import com.qianfeng.vo.VService;
import com.qianfeng.vo.VServiceShort;

@Service
public class SysCstServiceServiceImpl implements SysCstServiceService{

	@Autowired
	private SysCstServiceMapper cstServiceDao;
	
	@Override
	public void addService(SysCstService sysCstService, SysUser user) {
		// TODO Auto-generated method stub
		sysCstService.setSerCreateId(user.getUsrId());
		sysCstService.setSerFlag(0);
		
		try {
			cstServiceDao.insertSelective(sysCstService);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public Map<String, Object> findByPage(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		//list得到的是分页后的数据
		List<VServiceShort> list = cstServiceDao.selectAllVS();
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());//总记录个数
		map.put("rows", list);//分页的数据
		
		return map;
	}

	@Override
	public Map<String, Object> searchByPage(int page,  SysCstService sysCstService) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		List<VServiceShort> list = cstServiceDao.selectVSByService(sysCstService);
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());//总记录个数
		map.put("rows", list);//分页的数据
		
		return map;
	}

	@Override
	public SysCstService findService(int id) {
		// TODO Auto-generated method stub
		SysCstService cstService = cstServiceDao.selectByPrimaryKey(id);
		
		return cstService;
	}
	

}
