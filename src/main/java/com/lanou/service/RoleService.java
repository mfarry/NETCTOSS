package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.RoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dllo on 17/10/27.
 */
public interface RoleService {
    List<RoleInfo> queryAllRole();
    PageInfo<RoleInfo> getPageinfo(Integer pageNo, Integer pageSize);
    RoleInfo findRoleId(String name);
    int addRole(@Param("roleId") Integer roleId,@Param("moduleId") Integer mle);
    int insert(RoleInfo record);
    RoleInfo searchNameId(RoleInfo roleInfo);
    int deleteByPrimaryKey(Integer roleId);
    int deleteMid(Integer roleId);

    RoleInfo selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKey(RoleInfo record);
}
