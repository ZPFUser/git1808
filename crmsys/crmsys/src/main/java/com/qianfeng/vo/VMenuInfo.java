package com.qianfeng.vo;

import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class VMenuInfo {

	private Integer id;//子菜单中父菜单的id
	private String menuName;//父菜单名字
	private String url;
	private List<VMenuInfo> cMenuList;//子菜单列表
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<VMenuInfo> getcMenuList() {
		return cMenuList;
	}
	public void setcMenuList(List<VMenuInfo> cMenuList) {
		this.cMenuList = cMenuList;
	} 
	
	
	
	
	
}
