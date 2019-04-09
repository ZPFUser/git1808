package com.qianfeng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qianfeng.dao.SysRightMapper;
import com.qianfeng.pojo.SysRight;
import com.qianfeng.service.SysRightService;
import com.qianfeng.vo.VMenuInfo;

@Service
public class SysRightServiceImpl implements SysRightService{

	@Autowired
	private SysRightMapper rightDao;
	
	@Override
	public List<VMenuInfo> findRightByRid(Integer rid) {
		// TODO Auto-generated method stub
		//根据角色id查询权限数据
		List<SysRight> rightList = rightDao.selectByRoleId(rid);
		
		//封装成List<VmenuInfo>对象
		List<VMenuInfo> menuList = new ArrayList<>();
		
		for (SysRight right : rightList) {
			Integer parentCode = right.getRightParentCode();
			//说明是父菜单项
			if (parentCode == null) {
				int flag = 0;
				//判断是否有相同的父菜单名称
				for (VMenuInfo menuInfo : menuList) {
					if (menuInfo.getMenuName().equals(right.getRightName())) {
						flag = 1;
						break;
					}
				}
				
				//说明没有同名的父菜单项
				if(flag==0) {
					//创建父菜单项
					VMenuInfo mInfo = new VMenuInfo();
					mInfo.setId(right.getRightCode());
					mInfo.setMenuName(right.getRightName());
					mInfo.setUrl(right.getRightUrl());
					
					List<VMenuInfo> cList = new ArrayList<>();
					mInfo.setcMenuList(cList);
					menuList.add(mInfo);
				}
			} else { //说明是子菜单项
				for (VMenuInfo menuInfo : menuList) {
					//如果找到子菜单对应的父菜单项
					if (right.getRightParentCode() == menuInfo.getId()) {
						VMenuInfo cMenu = new VMenuInfo();
						cMenu.setId(right.getRightCode());
						cMenu.setMenuName(right.getRightName());
						cMenu.setUrl(right.getRightUrl());
						
						//添加到父菜单的子菜单列表中
						menuInfo.getcMenuList().add(cMenu);
						break;
					}
				}
			}
		
		}
		return menuList;
	}

	@Override
	public List<VMenuInfo> selectByRid(Integer rid) {
		// TODO Auto-generated method stub
		
		List<VMenuInfo> list = rightDao.selectByRid(rid);
		
		return list;
	}

}
