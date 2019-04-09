package com.qianfeng.controller;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.qianfeng.common.JsonBean;
import com.qianfeng.pojo.SysSalChance;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysSalChanceService;
import com.qianfeng.utils.JsonUtils;

@Controller
@RequestMapping("/sal")
public class SalChanceController {

	@Autowired
	private SysSalChanceService salChanceService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonBean findsalChanceByPage(int page) {
		
		JsonBean bean = null;
		try {
			Map<String, Object> map = salChanceService.findByPage(page);
			bean = JsonUtils.createJsonBean(1, map);
			
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
			
		}
		return bean;
	}
	
	@RequestMapping("/search.do")
	@ResponseBody
	public JsonBean searchByPage(int page, SysSalChance salChance) {
		
		JsonBean bean = null;
		try {
			Map<String, Object> map = salChanceService.searchByRecord(page, salChance);
			bean = JsonUtils.createJsonBean(1, map);
			
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
			
		}
		return bean;
	}
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonBean addSalChance(SysSalChance salChance, HttpSession session) {
		JsonBean bean = null;
		SysUser user = (SysUser)session.getAttribute("user");
		try {
			salChanceService.addSalChance(salChance, user);
			bean = JsonUtils.createJsonBean(1, "添加成功！");
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
		
	}
	
	
}
