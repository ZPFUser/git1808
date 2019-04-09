package com.qianfeng.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.common.JsonBean;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysUserService;
import com.qianfeng.utils.JsonUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private SysUserService userService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonBean findUserByPage(int page) {
		
		JsonBean bean = null;
		try {
			Map<String, Object> map = userService.findByPage(page);
			bean = JsonUtils.createJsonBean(1, map);
			
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
			
		}
		return bean;
	}
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonBean addSysUser(SysUser user) {
		JsonBean bean = null;
		try {
			userService.addUser(user);
			bean = JsonUtils.createJsonBean(1, null);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public JsonBean deleteUserById(int id) {
		
	
		JsonBean bean = null;
		try {
			userService.delectUserByUid(id);
			JsonUtils.createJsonBean(1, null);
		} catch (Exception e) {
			// TODO: handle exception
			JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	
	@RequestMapping("/findManager.do")
	@ResponseBody
	public JsonBean findManager() {
		JsonBean bean = null;
		try {
			List<SysUser> list = userService.findManager();
			bean = JsonUtils.createJsonBean(1, list);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/findUser.do")
	@ResponseBody
	public JsonBean findUser(HttpSession session) {
		
		
		JsonBean bean = null;
		try {
			SysUser user = (SysUser) session.getAttribute("user");
			bean = JsonUtils.createJsonBean(1, user);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
		
	}
	
}
