package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.mapper.AccountMapper;
import com.lanou.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/23.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;


    public List<Account> queryAllAccount() {
        return accountMapper.queryAllAccount();
    }

    public Account selectByPrimaryKey(Integer accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    public int updateByPrimaryKey(Account record) {
        return accountMapper.updateByPrimaryKey(record);
    }


    public PageInfo<Account> getPageinfo(Integer pageNo, Integer pageSize ) {
        return queryAccount(pageNo,pageSize);


    }

//    public PageInfo<Account> pageInfo(Integer pageNo, Integer pageSize, Account account) {
//        return search(pageNo,pageSize,account);
//    }


    public int insert(Account record) {
        return accountMapper.insert(record);
    }

    public int updateById(Account record) {
        return accountMapper.updateById(record);
    }

    public int updateFee(Account record) {
        return accountMapper.updateFee(record);
    }

    public int delPause(Integer accountId) {
        return accountMapper.delPause(accountId);
    }

    public int updateClo(Account record) {
        return accountMapper.updateClo(record);
    }

    public List<Account> serch(Account account) {
        return accountMapper.search(account);
    }

    public Account searchAccount(Account account) {
        return accountMapper.searchAccount(account);
    }


    public PageInfo<Account>queryAccount(Integer pageNo, Integer pageSize){



        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?5:pageSize;

        PageHelper.startPage(pageNo,pageSize);

//        获取全部的学员
        List<Account>accountList=accountMapper.queryAllAccount();

//        使用PageInfo对结果进行包装
        PageInfo<Account>pageInfo=new PageInfo<Account>(accountList);

        System.out.println(pageInfo);

        return pageInfo;
    }



    public PageInfo<Account>search(Integer pageNo, Integer pageSize,Account account){

        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?5:pageSize;

        PageHelper.startPage(pageNo,pageSize);

//        获取全部的学员
        List<Account>accountList=accountMapper.search(account);

//        使用PageInfo对结果进行包装
        PageInfo<Account>pageInfo=new PageInfo<Account>(accountList);

        System.out.println(pageInfo);

        return pageInfo;
    }


}
