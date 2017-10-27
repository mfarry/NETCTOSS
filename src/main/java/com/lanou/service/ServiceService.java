package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.bean.Service;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface ServiceService {
    List<Service> queryAllService();

    List<Account>queryAccount(Integer accountId);

    int updatePause(Service service);

    PageInfo<Service> getPageinfo(Integer pageNo, Integer pageSize);

    int updateById(Service service);

    int servicePause(Service service);

    Service selectByPrimaryKey(Integer serviceId);

    int delService(Service service);

    int insert(Service record);
    List<Service>searchService(
          @Param("osUsername") String osUsername,
          @Param("unixHost")  String unixHost,
          @Param("idcardNo")  String idcardNo,
          @Param("status")  String status);
}
