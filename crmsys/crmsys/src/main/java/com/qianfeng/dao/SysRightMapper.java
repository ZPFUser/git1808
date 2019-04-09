package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.pojo.SysRight;
import com.qianfeng.vo.VMenuInfo;

public interface SysRightMapper {
    int deleteByPrimaryKey(Integer rightCode);

    int insert(SysRight record);

    int insertSelective(SysRight record);

    SysRight selectByPrimaryKey(Integer rightCode);

    int updateByPrimaryKeySelective(SysRight record);

    int updateByPrimaryKey(SysRight record);

    //根据角色id查询拥有的权限数据
    public List<SysRight> selectByRoleId(Integer rid);

    public List<VMenuInfo> selectByRid(Integer rid);
}