package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.pojo.SysSalChance;

import net.sf.jsqlparser.statement.select.Select;

public interface SysSalChanceMapper {
    int deleteByPrimaryKey(Integer chcId);

    int insert(SysSalChance record);

    int insertSelective(SysSalChance record);

    SysSalChance selectByPrimaryKey(Integer chcId);

    int updateByPrimaryKeySelective(SysSalChance record);

    int updateByPrimaryKey(SysSalChance record);
    
    List<SysSalChance> selectAll();
    
    List<SysSalChance> selectByRecord(SysSalChance record);
}