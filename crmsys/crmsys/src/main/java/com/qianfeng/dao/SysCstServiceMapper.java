package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.pojo.SysCstCustomer;
import com.qianfeng.pojo.SysCstService;
import com.qianfeng.vo.VService;
import com.qianfeng.vo.VServiceShort;

public interface SysCstServiceMapper {
    int deleteByPrimaryKey(Integer serId);

    int insert(SysCstService record);

    int insertSelective(SysCstService record);

    SysCstService selectByPrimaryKey(Integer serId);

    int updateByPrimaryKeySelective(SysCstService record);

    int updateByPrimaryKey(SysCstService record);
    
    List<VService> selectAllV();
    
    List<VServiceShort> selectAllVS();
    
    List<VService> selectVByRecord(SysCstService sysCstService);
    
    List<VServiceShort> selectVSByService(SysCstService service);
    
    
    
}