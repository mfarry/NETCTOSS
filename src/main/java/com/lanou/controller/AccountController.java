package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.service.AccountService;
import com.lanou.utils.AjaxResult;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/10/23.
 */
@Controller
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/account")
    public String account() {

        return "/account/account_list";
    }

    @RequestMapping(value = "/aMod")
    public String aMod() {

        return "/account/account_modi";
    }

    @RequestMapping(value = "/aAdd")
    public String aAdd() {

        return "/account/account_add";
    }

    @RequestMapping(value = "/aDetail")
    public String aDetail() {

        return "/account/account_detail";
    }


    @ResponseBody
    @RequestMapping(value = "/queryAll")
    public AjaxResult query() {
        List<Account> accountList = accountService.queryAllAccount();


        return new AjaxResult(accountList);
    }

    @ResponseBody
    @RequestMapping(value = "/findByIdAccount")
    public AjaxResult findByIdAccount(Integer accountId) {


        Account account = accountService.selectByPrimaryKey(accountId);


        return new AjaxResult(account);

    }

    @ResponseBody
    @RequestMapping(value = "/deleteAccount")
    public AjaxResult deleteAccount(Account record) {

        int i = accountService.updateByPrimaryKey(record);

        return new AjaxResult(i);

    }

    @ResponseBody
    @RequestMapping(value = "/findIdAccount")
    public AjaxResult findIdAccount(HttpServletRequest request, HttpServletResponse response, Integer accountId) {
        Account key = accountService.selectByPrimaryKey(accountId);
        HttpSession session = request.getSession();
        session.setAttribute("account", key);

        return new AjaxResult(key);

    }


    @ResponseBody
    @RequestMapping(value = "/allAccount")
    public AjaxResult allAccount(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Account acount = (Account) session.getAttribute("account");


        return new AjaxResult(acount);
    }

    @ResponseBody
    @RequestMapping(value = "/pageinfoacount")
    public PageInfo<Account> pageInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pagesize") Integer pageSize) {


        return accountService.getPageinfo(pageNo, pageSize);
    }

//    @ResponseBody
//    @RequestMapping(value = "/page")
//    public PageInfo<Account> getpageInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pagesize") Integer pageSize,Account account) {
//
//
//        return accountService.pageInfo(pageNo,pageSize,account);
//    }


    @ResponseBody
    @RequestMapping(value = "/addAccount")
    public AjaxResult addAccount(Account record) {

        record.setStatus("1");
        int i = accountService.insert(record);

        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAccount")
    public AjaxResult updateAccount(Account record) {

        int i = accountService.updateById(record);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/updateFee")
    public AjaxResult updateFee(Account record) {

        int i = accountService.updateFee(record);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/delPause")
    public AjaxResult delPause(Integer accountId) {
        int i = accountService.delPause(accountId);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/pause")
    public AjaxResult updateClo(Account record) {

        int i = accountService.updateClo(record);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/search")
    public AjaxResult search( Account account){
        if (account.getLoginName().equals("")){
            account.setLoginName(null);
        }
        if (account.getIdcardNo().equals("")){
            account.setIdcardNo(null);
        }
        if (account.getRealName().equals("")){
            account.setRealName(null);
        }

        if (account.getStatus().equals("")){
            account.setStatus(null);
        }
        List<Account> accountList = accountService.serch(account);
        System.out.println(accountList);
        return new AjaxResult(accountList);

    }
    @ResponseBody
    @RequestMapping(value = "/findAccountId")
    public AjaxResult findAccountId(HttpServletRequest request,HttpServletResponse response,Integer accountId){
        HttpSession session=request.getSession();
        Account account = accountService.selectByPrimaryKey(accountId);
        session.setAttribute("account",account);

        return new AjaxResult(account);
    }
    @ResponseBody
    @RequestMapping(value = "/getAccountDetail")
    public AjaxResult getAccountDetail(HttpServletRequest request,HttpServletResponse response){
        HttpSession session=request.getSession();
      Account account = (Account) session.getAttribute("account");

      return new AjaxResult(account);

    }
}
