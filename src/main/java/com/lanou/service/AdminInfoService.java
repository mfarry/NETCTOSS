package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.AdminInfo;
import com.lanou.bean.Cost;
import com.lanou.bean.ModuleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public interface AdminInfoService {

    AdminInfo find(AdminInfo adminInfo);

    List<AdminInfo>queryAllAdmin();

    PageInfo<AdminInfo> getPageinfo(Integer pageNo, Integer pageSize);

    int deleteByPrimaryKey(Integer adminId);

    int delAdminRole(Integer adminId);

    int insert(AdminInfo record);

    AdminInfo searchAdminNameById(AdminInfo adminInfo);

    int addAdminMid(@Param("adminId") Integer adminId, @Param("roleId") Integer roleId);


    AdminInfo selectByPrimaryKey(Integer adminId);


    int updateByPrimaryKey(AdminInfo record);

    List<ModuleInfo>getAllModule();

    List<AdminInfo>hlSearchAdmin(@Param("adminId") Integer adminId,@Param("name") Integer name);
}
