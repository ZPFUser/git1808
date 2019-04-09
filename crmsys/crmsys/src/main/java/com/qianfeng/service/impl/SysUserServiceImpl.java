package com.qianfeng.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.dao.SysUserMapper;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper userDao;
	
	@Override
	public SysUser login(String name, String password) {
		// TODO Auto-generated method stub
		SysUser user = userDao.selectByName(name);
		
		if(user == null) {
			throw new RuntimeException("用户名错误");
		}
		if(user.getUsrFlag().equals("0")) {
			throw new RuntimeException("用户已禁用");
		}
		
		if (!user.getUsrPassword().equals(password)) {
			throw new RuntimeException("密码错误");
		}
		
		return user;
	}

	@Override
	public Map<String, Object> findByPage(int page) {
		// TODO Auto-generated method stub
		
		//pageHelper插件中提供的方法,后面一定要紧跟着一个执行查询操作的方法
		
		//第一个参数，页码；第二个参数，每页显示的记录
		//Page<Object> startPage = PageHelper.startPage(page, 10);
		
		PageHelper.startPage(page, 10);
		//list得到的是分页后的数据
		List<SysUser> list = userDao.selectAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("total", ((Page)list).getTotal());//总记录个数
		map.put("rows", list);//分页的数据
		
		return map;
	}

	@Override
	public void addUser(SysUser user) {
		// TODO Auto-generated method stub
		
		//判断用户名是否重复
		
		SysUser user2 = userDao.selectByName(user.getUsrName());
		if (user2 == null) {
			//添加用户
			user.setUsrFlag("1");
			userDao.insertSelective(user);
			
		} else {
			throw new RuntimeException("用户名已存在");
		}
		
		
	}

	@Override
	public void delectUserByUid(int id) {
		// TODO Auto-generated method stub
		//需要判断用户是否可以删除
		SysUser user = new SysUser();
		user.setUsrId(id);
		user.setUsrFlag("0");
		
		userDao.updateByPrimaryKeySelective(user);
		
	}

	@Override
	public void addMultiUser(List<SysUser> list) {
		// TODO Auto-generated method stub
		userDao.insertMultiInfo(list);
	}

	@Override
	public List<SysUser> findManager() {
		// TODO Auto-generated method stub
		List<SysUser> list = userDao.selectManager();
		
		return list;
	}

}
