package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.pojo.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer usrId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer usrId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectByName(String Name);
    
    List<SysUser> selectAll();
    
    void insertMultiInfo(List<SysUser> list);
    
    List<SysUser> selectManager();

}