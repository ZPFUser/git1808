package com.qianfeng.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.qianfeng.service.SysCstCustomerService;

public class UserTest extends BaseTest{

	@Autowired
	private SysCstCustomerService cst;
	
	@Test
	@Rollback
	public void Lists() {
		
		Map<String, Object> map = cst.findByPage(1);
		
			System.out.println(map.get("total"));
			System.out.println(map.get("rows"));
			
		}
	
	}
	