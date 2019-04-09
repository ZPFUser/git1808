package com.qianfeng.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.qianfeng.service.SysRightService;
import com.qianfeng.vo.VMenuInfo;

public class MenuTest extends BaseTest{

	@Autowired
	private SysRightService rightService;
	
	@Test
	@Rollback
	public void menus() {
		List<VMenuInfo> list = rightService.findRightByRid(1);
		
		for (VMenuInfo vMenuInfo : list) {
			System.out.println(vMenuInfo.getMenuName());
			for (VMenuInfo cMenuInfo : vMenuInfo.getcMenuList()) {
				System.out.println(cMenuInfo.getMenuName());
			}
		}
	
	}
	
	@Test
	public void menus2() {
		List<VMenuInfo> list = rightService.selectByRid(1);
		
		for (VMenuInfo vMenuInfo : list) {
			System.out.println(vMenuInfo.getMenuName());
			for (VMenuInfo cMenuInfo : vMenuInfo.getcMenuList()) {
				System.out.println(cMenuInfo.getMenuName());
			}
		}
	
	}
	
	
}
