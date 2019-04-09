package com.qianfeng.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.ibatis.exceptions.ExceptionFactory;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qianfeng.common.JsonBean;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysUserService;
import com.qianfeng.utils.JsonUtils;

@Controller
//4使用该注解修饰控制器类
@Validated
public class LoginController {

	@Autowired
	private SysUserService userService;
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	//5 在方法参数里直接使用验证的注解
	public JsonBean login(@NotEmpty(message ="{name.Empty}") String name, String password, HttpSession session) {
	
		JsonBean bean = null;
		
		try {
			SysUser user = userService.login(name, password);
			session.setAttribute("user", user);
			bean = JsonUtils.createJsonBean(1, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			bean = JsonUtils.createJsonBean(0, e.getMessage());
		}
		
		return bean;
	
	}
	
	// springmvc异常处理的方法，需要使用@ExceptionHandler修饰，一般会指定一个需要处理的异常
		// 如果报指定的异常，就会调用该方法
		// 如果验证不通过，会报ConstraintViolationException
		@ExceptionHandler(ConstraintViolationException.class)
		public JsonBean exception(ConstraintViolationException  e){
			String expInfo = null;
			// 获取验证不通过的异常信息
			Iterator<ConstraintViolation<?>> iterator = e.getConstraintViolations().iterator();
			while(iterator.hasNext()){
				ConstraintViolation<?> next = iterator.next();
				// 获取验证不通过的信息
				System.out.println(next.getMessage());
				expInfo += next.getMessage() + ";";
			}
			System.out.println("exception method");
			return JsonUtils.createJsonBean(0, expInfo);
		}
		
	
	
	
}
