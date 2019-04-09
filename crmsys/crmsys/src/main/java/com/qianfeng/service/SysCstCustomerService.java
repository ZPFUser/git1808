package com.qianfeng.service;

import java.util.List;
import java.util.Map;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.qianfeng.pojo.SysCstCustomer;
import com.qianfeng.vo.VAddCus;


public interface SysCstCustomerService {
	
	 public Map<String, Object> findByPage(int page);
	 
	 public VAddCus findCus();
	 
	 public void addCus(SysCstCustomer customer);

	 public Map<String, Object> findByRecode(int page, SysCstCustomer customer);
	 
	 public SysCstCustomer findById(int id);
	 
	 public void modifyCustomer(int id, SysCstCustomer customer);

	 public List<SysCstCustomer> findAllCus();
	 
	 public SysCstCustomer findBySerId(Integer sid);
}
