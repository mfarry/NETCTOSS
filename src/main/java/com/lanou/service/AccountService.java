package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;

import java.util.List;

/**
 * Created by dllo on 17/10/23.
 */
public interface AccountService {

    List<Account> queryAllAccount();
    Account selectByPrimaryKey(Integer accountId);
    int updateByPrimaryKey(Account record);

    PageInfo<Account> getPageinfo(Integer pageNo, Integer pageSize);

//    PageInfo<Account>search(Integer pageNo, Integer pageSize,Account account);


    int insert(Account record);

    int updateById(Account record);

    int updateFee(Account record);

    int delPause(Integer accountId);

    int updateClo(Account record);

List<Account>serch(Account account);

    Account searchAccount(Account account);

}
