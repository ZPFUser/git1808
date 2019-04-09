package com.qianfeng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.util.ElementScanner6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.SysBasDictMapper;
import com.qianfeng.pojo.SysBasDict;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysBasDictService;

@Service
public class SysBasDictServiceImpl implements SysBasDictService{

	@Autowired
	private SysBasDictMapper basDictDao;
	
	@Override
	public Map<String, Object> findByPage(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		//list得到的是分页后的数据
		List<SysBasDict> list = basDictDao.selectAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());//总记录个数
		map.put("rows", list);//分页的数据
		
		return map;
	}

	@Override
	public void addDict(SysBasDict basDict) {
		// TODO Auto-generated method stub
		//SysBasDict ti = basDictDao.selectDictByTI(basDict.getDictType(), basDict.getDictItem());
		
		//if(ti == null) {
			basDict.setDictStatus(1);
			basDictDao.insertSelective(basDict);
		//} else {
			//throw new RuntimeException("已有此类型");
		//}
		
	}

	@Override
	public Map<String, Object> searchByRecord(int page, SysBasDict basDict) {
		// TODO Auto-generated method stub
		
		PageHelper.startPage(page, 5);
		//list得到的是分页后的数据
		 List<SysBasDict> list = basDictDao.selectByRecord(basDict);
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());//总记录个数
		map.put("rows", list);//分页的数据
		
		return map;
	}

	@Override
	public void delectDict(int id) {
		// TODO Auto-generated method stub
		SysBasDict bas = new SysBasDict();
		bas.setDictId(id);
		bas.setDictStatus(0);
		bas.setDictIsEditable(false);
		basDictDao.updateByPrimaryKeySelective(bas);
		
	}

	@Override
	public SysBasDict findDictById(int id) {
		// TODO Auto-generated method stub
		SysBasDict dict = basDictDao.selectByPrimaryKey(id);
		
		return dict;
	}

	@Override
	public void modifyDict(SysBasDict basDict) {
		// TODO Auto-generated method stub
		basDictDao.updateByPrimaryKeySelective(basDict);
	}

	@Override
	public List<SysBasDict> findSerType() {
		// TODO Auto-generated method stub
		List<SysBasDict> list = basDictDao.selectSerType();
		
		return list;
	}

}
