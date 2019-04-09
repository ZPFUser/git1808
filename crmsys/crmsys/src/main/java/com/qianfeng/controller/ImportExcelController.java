package com.qianfeng.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.bytecode.LineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.pojo.SysUser;
import com.qianfeng.service.SysUserService;
import com.qianfeng.utils.ExcelUtils;
import com.qianfeng.utils.JsonUtils;

@Controller
public class ImportExcelController {
	
	@Autowired
	private SysUserService userService;

	@RequestMapping("/importExcel.do")
	@ResponseBody
	public JsonBean importExcel(@RequestParam MultipartFile excelFile) {
		
		JsonBean bean = null;
		
		//获取上传的文件名
		String fileName = excelFile.getOriginalFilename();
		//获取上传文件的输入流
		InputStream inputStream = null;
		try {
			inputStream = excelFile.getInputStream();
			List<Map<String,Object>> list = ExcelUtils.readExcel2(fileName, inputStream);
		//	System.out.println(list);
			//jackson中将对象转字符串，json字符串转为对象
			ObjectMapper objMapper = new ObjectMapper();
			//对象转字符串
			String jsonStr = objMapper.writeValueAsString(list);
			
			//json字符串转为指定对象
			List<SysUser> userList = objMapper.readValue(jsonStr, new TypeReference<List<SysUser>>() {
			});
			
			userService.addMultiUser(userList);
			
			bean= JsonUtils.createJsonBean(1, "导入成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean = JsonUtils.createJsonBean(0, "导入失败");
		}
		
		return bean;
	}
	
	@RequestMapping("/exportExcel.do")
	public void exportExcel(HttpServletResponse response) {
		String file ="aa.xlsx";
		
		try {
			file = URLEncoder.encode(file, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
		}
		
		//设置Content-Disposition响应头
		response.setHeader("Content-Disposition", "attachment;filename=" + file);
	
		//获取相应的输出流
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			
			ExcelUtils.exportExcel(outputStream);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
