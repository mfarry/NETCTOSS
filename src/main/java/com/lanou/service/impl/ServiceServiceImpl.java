package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.bean.Service;
import com.lanou.mapper.ServiceMapper;
import com.lanou.service.ServiceService;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Resource
    private ServiceMapper serviceMapper;
    public List<Service> queryAllService() {
        return serviceMapper.queryAllService();
    }

    public List<Account> queryAccount(Integer accountId) {
        return serviceMapper.queryAccount(accountId);
    }

    public int updatePause(Service service) {
        return serviceMapper.updatePause(service);
    }


    public PageInfo<Service> getPageinfo(Integer pageNo, Integer pageSize ) {
        return queryCost(pageNo,pageSize);


    }

    public int updateById(Service service) {
        return serviceMapper.updateById(service);
    }

    public int servicePause(Service service) {
        return serviceMapper.servicePause(service);
    }

    public Service selectByPrimaryKey(Integer serviceId) {
        return serviceMapper.selectByPrimaryKey(serviceId);
    }

    public int delService(Service service) {
        return serviceMapper.delService(service);
    }

    public int insert(Service record) {
        return serviceMapper.insert(record);
    }

    public List<Service> searchService(
          @Param("osUsername") String osUsername,
          @Param("unixHost") String unixHost,
          @Param("idcardNo") String idcardNo,
          @Param("status") String status) {


        List<Service> services = serviceMapper.searchService(osUsername, unixHost, idcardNo, status);
        return services;
    }

    public Service findOs(String loginName) {
        return serviceMapper.findOs(loginName
        );
    }


    public PageInfo<Service>queryCost(Integer pageNo, Integer pageSize){



        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?5:pageSize;

        PageHelper.startPage(pageNo,pageSize);

//        获取全部的学员
        List<Service> services = serviceMapper.queryAllService();

//        使用PageInfo对结果进行包装
        PageInfo<Service>pageInfo=new PageInfo<Service>(services);

        System.out.println(pageInfo);

        return pageInfo;
    }

}
