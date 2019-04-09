package com.qianfeng.vo;

import java.util.List;

import com.qianfeng.pojo.SysBasDict;
import com.qianfeng.pojo.SysUser;

public class VAddCus {

	private List<SysBasDict> custRegion;
	private List<SysUser> custManager;
	private List<SysBasDict> custLevel;
	public List<SysBasDict> getCustRegion() {
		return custRegion;
	}
	public void setCustRegion(List<SysBasDict> custRegion) {
		this.custRegion = custRegion;
	}
	public List<SysUser> getCustManager() {
		return custManager;
	}
	public void setCustManager(List<SysUser> custManager) {
		this.custManager = custManager;
	}
	public List<SysBasDict> getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(List<SysBasDict> custLevel) {
		this.custLevel = custLevel;
	}
	
}
