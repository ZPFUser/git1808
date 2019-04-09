package com.qianfeng.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.common.JsonBean;
import com.qianfeng.pojo.SysCstCustomer;
import com.qianfeng.pojo.SysCstService;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysCstCustomerService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VAddCus;

@Controller
@RequestMapping("/customer")
public class CstCustomerController {

	@Autowired
	private SysCstCustomerService customerService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonBean findCustomerByPage(int page) {
		JsonBean bean = null;
		
		try {
			Map<String, Object> map = customerService.findByPage(page);
			bean = JsonUtils.createJsonBean(1, map);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/findCus.do")
	@ResponseBody
	public JsonBean findCus() {
		JsonBean bean = null;
		
		try {
			VAddCus cus = customerService.findCus();
			bean = JsonUtils.createJsonBean(1, cus);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
		
	}
	
	
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonBean addCus(SysCstCustomer customer) {
		JsonBean bean = null;
		
		try {
			customerService.addCus(customer);
			bean = JsonUtils.createJsonBean(1, "添加成功！");
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, "添加失败！");
		}
		
		return bean;
		
	}
	
	
	@RequestMapping("/search.do")
	@ResponseBody
	public JsonBean search(int page,SysCstCustomer customer) {
		JsonBean bean = null;
		try {
			Map<String, Object> map = customerService.findByRecode(page, customer);
			bean = JsonUtils.createJsonBean(1, map);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/find.do")
	@ResponseBody
	public JsonBean findById(int id) {
		JsonBean bean = null;
		try {
			SysCstCustomer customer = customerService.findById(id);
			bean = JsonUtils.createJsonBean(1, customer);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/modify.do")
	@ResponseBody
	public JsonBean modifyCustomer(int id, SysCstCustomer customer) {
		JsonBean bean = null;
		try {
			customerService.modifyCustomer(id, customer);
			bean = JsonUtils.createJsonBean(1, "修改成功！");
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/findAll.do")
	@ResponseBody
	public JsonBean findAllCustomer() {
		JsonBean bean = null;
		try {
			List<SysCstCustomer> list = customerService.findAllCus();
			bean = JsonUtils.createJsonBean(1, list);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/searchById.do")
	@ResponseBody
	public  JsonBean searchById(Integer sid) {
		JsonBean bean = null;
		
		try {
			SysCstCustomer customer = customerService.findBySerId(sid);
			bean = JsonUtils.createJsonBean(1, customer);
		} catch (Exception e) {
			// TODO: handle exception
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
	}
	
	
}
