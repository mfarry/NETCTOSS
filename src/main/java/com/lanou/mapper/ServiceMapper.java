package com.lanou.mapper;

import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.bean.Service;

import java.util.List;

public interface ServiceMapper {
    int deleteByPrimaryKey(Integer serviceId);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Integer serviceId);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);

    int updateById(Service service);

    int updatePause(Service service);

    List<Service>queryAllService();

    List<Account>queryAccount(Integer accountId);

    List<Cost>queryCost(Integer costId);

    int servicePause(Service service);

    int delService(Service service);



}