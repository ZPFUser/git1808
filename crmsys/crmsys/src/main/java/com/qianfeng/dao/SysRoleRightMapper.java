package com.qianfeng.dao;

import com.qianfeng.pojo.SysRoleRight;

public interface SysRoleRightMapper {
    int deleteByPrimaryKey(Integer rfId);

    int insert(SysRoleRight record);

    int insertSelective(SysRoleRight record);

    SysRoleRight selectByPrimaryKey(Integer rfId);

    int updateByPrimaryKeySelective(SysRoleRight record);

    int updateByPrimaryKey(SysRoleRight record);
}