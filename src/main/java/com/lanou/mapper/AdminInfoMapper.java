package com.lanou.mapper;

import com.lanou.bean.AdminInfo;
import com.lanou.bean.ModuleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminInfoMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    AdminInfo selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminInfo record);

    int updateByPrimaryKey(AdminInfo record);

  AdminInfo  find(AdminInfo adminInfo);

  List<AdminInfo>queryAllAdmin();

  int delAdminRole(Integer adminId);

  AdminInfo searchAdminNameById(AdminInfo adminInfo);

  int addAdminMid(@Param("adminId") Integer adminId, @Param("roleId") Integer roleId);

  List<ModuleInfo>getAllModule();

    List<AdminInfo>hlSearchAdmin(@Param("adminId") Integer adminId,@Param("name") Integer name);
}