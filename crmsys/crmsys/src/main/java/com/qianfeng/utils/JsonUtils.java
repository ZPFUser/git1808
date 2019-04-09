package com.qianfeng.utils;

import com.qianfeng.common.JsonBean;

public class JsonUtils {

	public static JsonBean createJsonBean(int code, Object info) {
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);
		
		return bean;
	}
}
