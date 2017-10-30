package com.lanou.mapper;

import com.lanou.bean.RoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleInfoMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

  RoleInfo selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

    List<RoleInfo>queryAllRole();

    RoleInfo findRoleId(String name);

    int addRole(@Param("roleId") Integer roleId,@Param("moduleId") Integer moduleId);

    RoleInfo searchNameId(RoleInfo roleInfo);

    int deleteMid(Integer roleId);

}