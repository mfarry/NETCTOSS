package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public interface CostService {
    List<Cost>findAll();

    int deleteByPrimaryKey(Integer costId);


    int insert(Cost record);


    Cost selectByPrimaryKey(Integer costId);

    int updateByPrimaryKey(Cost record);


    int update(Cost cost);

    int updateStartTime(Cost cost);


//    List<Cost>findWithPageInfo(Integer pageNo,Integer pageSize);

    PageInfo<Cost> getPageinfo(Integer pageNo,Integer pageSize);
}
