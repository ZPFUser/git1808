package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.pojo.SysCstCustomer;
import com.qianfeng.vo.VCustomer;

public interface SysCstCustomerMapper {
    int deleteByPrimaryKey(Integer custId);

    int insert(SysCstCustomer record);

    int insertSelective(SysCstCustomer record);

    SysCstCustomer selectByPrimaryKey(Integer custId);

    int updateByPrimaryKeySelective(SysCstCustomer record);

    int updateByPrimaryKey(SysCstCustomer record);
    
    List<VCustomer> selectAll();
    
    List<VCustomer> selectByRecord(SysCstCustomer customer);
    
    List<SysCstCustomer> selectAllCustomer();
    
    SysCstCustomer selectCustomer(Integer serId);
}