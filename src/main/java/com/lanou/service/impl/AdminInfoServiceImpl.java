package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.AdminInfo;
import com.lanou.bean.Cost;
import com.lanou.bean.ModuleInfo;
import com.lanou.mapper.AdminInfoMapper;
import com.lanou.service.AdminInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Resource
    private AdminInfoMapper adminInfoMapper;

    public AdminInfo find(AdminInfo adminInfo) {
        return  adminInfoMapper.find(adminInfo);
    }

    public List<AdminInfo> queryAllAdmin() {
        return adminInfoMapper.queryAllAdmin();
    }


    public PageInfo<AdminInfo> getPageinfo(Integer pageNo, Integer pageSize ) {
        return queryCost(pageNo,pageSize);


    }

    public int deleteByPrimaryKey(Integer adminId) {
        return adminInfoMapper.deleteByPrimaryKey(adminId);
    }

    public int delAdminRole(Integer adminId) {
        return adminInfoMapper.delAdminRole(adminId);
    }

    public int insert(AdminInfo record) {
        return adminInfoMapper.insert(record);
    }

    public AdminInfo searchAdminNameById(AdminInfo adminInfo) {
        return adminInfoMapper.searchAdminNameById(adminInfo);
    }

    public int addAdminMid(@Param("adminId") Integer adminId, @Param("roleId") Integer roleId) {
        return adminInfoMapper.addAdminMid(adminId,roleId);
    }

    public AdminInfo selectByPrimaryKey(Integer adminId) {
        return adminInfoMapper.selectByPrimaryKey(adminId);
    }

    public int updateByPrimaryKey(AdminInfo record) {
        return adminInfoMapper.updateByPrimaryKey(record);
    }

    public List<ModuleInfo> getAllModule() {
        return adminInfoMapper.getAllModule();
    }

    public List<AdminInfo> hlSearchAdmin(@Param("moduleId") Integer moduleId, @Param("name") String name) {
        System.out.println(name);
        return adminInfoMapper.hlSearchAdmin(moduleId,name);
    }

    public PageInfo<AdminInfo>queryCost(Integer pageNo, Integer pageSize){



        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?5:pageSize;

        PageHelper.startPage(pageNo,pageSize);

//        获取全部的学员
        List<AdminInfo>adminInfos=adminInfoMapper.queryAllAdmin();

//        使用PageInfo对结果进行包装
        PageInfo<AdminInfo>pageInfo=new PageInfo<AdminInfo>(adminInfos);



        return pageInfo;
    }
}
