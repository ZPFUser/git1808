package com.qianfeng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.SysBasDictMapper;
import com.qianfeng.dao.SysCstCustomerMapper;
import com.qianfeng.dao.SysUserMapper;
import com.qianfeng.pojo.SysBasDict;
import com.qianfeng.pojo.SysCstCustomer;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysCstCustomerService;
import com.qianfeng.vo.VCustomer;
import com.qianfeng.vo.VAddCus;

@Service
public class SysCstCustomerServiceImpl implements SysCstCustomerService{
	
	@Autowired
	private SysCstCustomerMapper customerDao;
	@Autowired
	private SysBasDictMapper dictDao;

	@Autowired
	private SysUserMapper userDao;
	
	@Override
	public Map<String, Object> findByPage(int page) {
		// TODO Auto-generated method stub
		
		PageHelper.startPage(page, 5);
		//list得到的是分页后的数据
		
		List<VCustomer> list = customerDao.selectAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());//总记录个数
		map.put("rows", list);//分页的数据
	
		return map;
	}

	@Override
	public VAddCus findCus() {
		// TODO Auto-generated method stub
		VAddCus addCus = new VAddCus();
		addCus.setCustRegion(dictDao.selectRegion());
		addCus.setCustLevel(dictDao.selectLevel());
		addCus.setCustManager(userDao.selectManager());
		
		return addCus;
	}

	@Override
	public void addCus(SysCstCustomer customer) {
		// TODO Auto-generated method stub
		try {
			
			customer.setCustStatus(1);
			customerDao.insertSelective(customer);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("service添加失败");
		}
		
	}


	@Override
	public Map<String, Object> findByRecode(int page, SysCstCustomer customer) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		//list得到的是分页后的数据
		List<VCustomer> list = customerDao.selectByRecord(customer);
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());//总记录个数
		map.put("rows", list);//分页的数据
		return map;
	}

	@Override
	public SysCstCustomer findById(int id) {
		// TODO Auto-generated method stub
		SysCstCustomer customer = customerDao.selectByPrimaryKey(id);
		return customer;
	}

	@Override
	public void modifyCustomer(int id,SysCstCustomer customer) {
		// TODO Auto-generated method stub
		customer.setCustId(id);
		try {
			customerDao.updateByPrimaryKeySelective(customer);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}
		
		
	}

	@Override
	public List<SysCstCustomer> findAllCus() {
		// TODO Auto-generated method stub
		List<SysCstCustomer> list = customerDao.selectAllCustomer();
		
		return list;
	}

	@Override
	public SysCstCustomer findBySerId(Integer sid) {
		// TODO Auto-generated method stub
		SysCstCustomer customer = customerDao.selectCustomer(sid);
		
		return customer;
	}

}
