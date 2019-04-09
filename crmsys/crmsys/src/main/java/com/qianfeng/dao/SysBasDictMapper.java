package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.pojo.SysBasDict;

import net.sf.jsqlparser.statement.select.Select;

public interface SysBasDictMapper {
    int deleteByPrimaryKey(Integer dictId);

    int insert(SysBasDict record);

    int insertSelective(SysBasDict record);

    SysBasDict selectByPrimaryKey(Integer dictId);

    int updateByPrimaryKeySelective(SysBasDict record);

    int updateByPrimaryKey(SysBasDict record);
    
    List<SysBasDict> selectAll();
    
    SysBasDict selectDictByTI(String dictType, String dictItem);

    List<SysBasDict> selectRegion();
    
     List<SysBasDict> selectLevel();
     
     List<SysBasDict> selectByRecord(SysBasDict record);

	List<SysBasDict> selectSerType();
    
}