package com.qianfeng.controller;

import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.common.JsonBean;
import com.qianfeng.pojo.SysBasDict;
import com.qianfeng.service.SysBasDictService;
import com.qianfeng.utils.JsonUtils;

@Controller
@RequestMapping("basDict")
public class BasDictController {

	@Autowired
	private SysBasDictService basDictService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonBean findBasDictByPage(int page) {
		JsonBean bean = null;
		
		try {
			Map<String, Object> map = basDictService.findByPage(page);
			bean = JsonUtils.createJsonBean(1, map);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonBean addBasDict(SysBasDict dict) {
		JsonBean bean = null;
		
		try {
			basDictService.addDict(dict);
			bean = JsonUtils.createJsonBean(1, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/search.do")
	@ResponseBody
	public JsonBean searchBasDict(int page, SysBasDict dict) {
		JsonBean bean = null;
		
		try {
			Map<String, Object> map = basDictService.searchByRecord(page, dict);
			bean = JsonUtils.createJsonBean(1, map);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/delect.do")
	@ResponseBody
	public JsonBean delectBasDict(int id) {
		JsonBean bean = null;
		
		try {
			basDictService.delectDict(id);
			bean = JsonUtils.createJsonBean(1, "删除成功！");
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, "删除失败！");
		}
		return bean;
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public  JsonBean findDictById(int id) {
		JsonBean bean = null;
		try {
			SysBasDict dict = basDictService.findDictById(id);
			bean = JsonUtils.createJsonBean(1, dict);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/modify.do")
	@ResponseBody
	public JsonBean modifyDict(SysBasDict dict) {
		JsonBean bean = null;
		try {
			basDictService.modifyDict(dict);
			
			bean = JsonUtils.createJsonBean(1, "修改成功！");
			
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/findType.do")
	@ResponseBody
	public JsonBean findAllType() {
		JsonBean bean = null;
		try {
			List<SysBasDict> list = basDictService.findSerType();
			
			bean = JsonUtils.createJsonBean(1, list);
			
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
}
