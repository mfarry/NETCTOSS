package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;
import com.lanou.mapper.CostMapper;
import com.lanou.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
@Service
public class CostServiceImpl implements CostService {
    @Resource
    private CostMapper costMapper;
    public List<Cost> findAll() {
        return costMapper.findAll();
    }



    public int deleteByPrimaryKey(Integer costId) {
        return costMapper.deleteByPrimaryKey(costId);
    }

    public int insert(Cost record) {

        return costMapper.insert(record);
    }

    public Cost selectByPrimaryKey(Integer costId) {
        return costMapper.selectByPrimaryKey(costId);
    }

    public int updateByPrimaryKey(Cost record) {
        return costMapper.updateByPrimaryKey(record);
    }

    public int update(Cost cost) {
        return costMapper.update(cost);
    }

    public int updateStartTime(Cost cost) {
        return costMapper.updateStartTime(cost);
    }



    public PageInfo<Cost> getPageinfo(Integer pageNo,Integer pageSize ) {
        return queryCost(pageNo,pageSize);


    }

        public PageInfo<Cost>queryCost(Integer pageNo, Integer pageSize){



            pageNo=pageNo==null?1:pageNo;
            pageSize=pageSize==null?5:pageSize;

            PageHelper.startPage(pageNo,pageSize);

//        获取全部的学员
            List<Cost>costList=costMapper.findAll();

//        使用PageInfo对结果进行包装
            PageInfo<Cost>pageInfo=new PageInfo<Cost>(costList);

            System.out.println(pageInfo);

            return pageInfo;
    }
}
