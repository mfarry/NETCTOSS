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

    //基费升序查询
    List<Cost> findCostAsc();

    //基费降序查询
    List<Cost> findCostDesc();

    //时长升序查询
    List<Cost> findDurationAsc();

    //时长降序查询
    List<Cost> findDurationDesc();

    PageInfo<Cost> findCostSort(Integer pageNo,Integer pageSize,Integer flag);
}
