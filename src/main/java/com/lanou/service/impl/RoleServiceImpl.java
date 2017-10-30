package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.RoleInfo;
import com.lanou.mapper.RoleInfoMapper;
import com.lanou.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/27.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleInfoMapper roleInfoMapper;
    public List<RoleInfo> queryAllRole() {
        return roleInfoMapper.queryAllRole();
    }


    public PageInfo<RoleInfo> getPageinfo(Integer pageNo, Integer pageSize ) {
        return queryCost(pageNo,pageSize);


    }

    public RoleInfo findRoleId(String name) {
        return roleInfoMapper.findRoleId(name);
    }

    public int addRole(@Param("roleId") Integer roleId,@Param("moduleId") Integer mle) {
        return roleInfoMapper.addRole(roleId,mle);
    }

    public int insert(RoleInfo record) {
        return roleInfoMapper.insert(record);
    }

    public RoleInfo searchNameId(RoleInfo roleInfo) {
        return roleInfoMapper.searchNameId(roleInfo);
    }

    public int deleteByPrimaryKey(Integer roleId) {
        return roleInfoMapper.deleteByPrimaryKey(roleId);
    }

    public int deleteMid(Integer roleId) {
        return roleInfoMapper.deleteMid(roleId);
    }

    public RoleInfo selectByPrimaryKey(Integer roleId) {
        return roleInfoMapper.selectByPrimaryKey(roleId);
    }

    public int updateByPrimaryKey(RoleInfo record) {
        return roleInfoMapper.updateByPrimaryKey(record);
    }


//    public RoleInfo getAllModule(Integer roleId) {
//        return roleInfoMapper.getAllModule(roleId);
//    }


    public PageInfo<RoleInfo>queryCost(Integer pageNo, Integer pageSize){



        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?5:pageSize;

        PageHelper.startPage(pageNo,pageSize);

//        获取全部的学员
        List<RoleInfo> roleInfos = roleInfoMapper.queryAllRole();

//        使用PageInfo对结果进行包装
        PageInfo<RoleInfo>pageInfo=new PageInfo<RoleInfo>(roleInfos);

        System.out.println(pageInfo);

        return pageInfo;
    }

}
