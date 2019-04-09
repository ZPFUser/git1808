package com.qianfeng.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.common.JsonBean;
import com.qianfeng.pojo.SysCstService;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysCstServiceService;
import com.qianfeng.utils.JsonUtils;

@Controller
@RequestMapping("/cstService")
public class CstServiceController {

	@Autowired
	private SysCstServiceService cService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonBean addService(SysCstService cstService, HttpSession session) {
		JsonBean bean = null;
		SysUser user = (SysUser)session.getAttribute("user");
		
		try {
			cService.addService(cstService, user);
			bean = JsonUtils.createJsonBean(1, "添加成功！");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
		
	}
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonBean findAllV(int page) {
		JsonBean bean = null;
		
		try {
			Map<String, Object> map = cService.findByPage(page);
			bean = JsonUtils.createJsonBean(1, map);
			
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
		
	}
	
	
	
	@RequestMapping("/search.do")
	@ResponseBody
	public JsonBean searchV(int page, SysCstService sysCstService) {
		JsonBean bean = null;
		
		try {
			Map<String, Object> map = cService.searchByPage(page, sysCstService);
			bean = JsonUtils.createJsonBean(1, map);
			
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
		
	}
	
	
	@RequestMapping("/searchById.do")
	@ResponseBody
	public  JsonBean searchById(int id) {
		JsonBean bean = null;
		
		try {
			SysCstService service = cService.findService(id);
			bean = JsonUtils.createJsonBean(1, service);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
	}
	
	
	
}
