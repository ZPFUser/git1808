package com.qianfeng.service;

import java.util.List;

import com.qianfeng.vo.VMenuInfo;

public interface SysRightService {

	public List<VMenuInfo> findRightByRid(Integer rid);//查权限，

	public List<VMenuInfo> selectByRid(Integer rid);
}
