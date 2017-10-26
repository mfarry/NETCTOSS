package com.lanou.mapper;

import com.lanou.bean.Account;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> queryAllAccount();

    int updateById(Account record);

    int updateFee(Account record);

    int delPause(Integer accountId);

    int updateClo(Account record);

    List<Account> search(Account account);

    Account searchAccount(Account account);
}