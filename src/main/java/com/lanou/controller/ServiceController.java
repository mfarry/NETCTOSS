package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.bean.Service;
import com.lanou.service.AccountService;
import com.lanou.service.ServiceService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Controller
public class ServiceController {

    @Resource
    private ServiceService serviceService;
    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/sList")
    public String sList(){
        return "/service/service_list";

    }


    @RequestMapping(value = "/sMod")
    public String sMod(){
        return "/service/service_modi";

    }

    @RequestMapping(value = "/sAdd")
    public String sAdd(){
        return "/service/service_add";

    }


    @ResponseBody
    @RequestMapping(value = "/queryAllService")
    public AjaxResult queryAllService(){
        List<Service> serviceList = serviceService.queryAllService();

        return new AjaxResult(serviceList);
    }
    @ResponseBody
    @RequestMapping(value = "/queryAccount")
    public AjaxResult queryAccount(Integer accountId){
        List<Account> accountList = serviceService.queryAccount(accountId);

        return new AjaxResult(accountList);

    }

    @ResponseBody
    @RequestMapping(value = "/servicepage")
    public PageInfo<Service> pageInfo(@RequestParam("pageNo") Integer pageNo , @RequestParam("pagesize") Integer pageSize){


        return serviceService.getPageinfo(pageNo,pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/updateServiceFee")
    public AjaxResult updateServiceFee(Service service){
        int i = serviceService.updateById(service);
        return new AjaxResult(i);
    }
    @ResponseBody
    @RequestMapping(value = "/delServicePause")
    public AjaxResult delServicePause(Service service){
        int i = serviceService.updatePause(service);
        return new AjaxResult(i);
    }
    @ResponseBody
    @RequestMapping(value = "/servicePause")
    public AjaxResult servicePause(Service service){
        System.out.println(service.getStatus());
        int i = serviceService.servicePause(service);
        return new AjaxResult(i);
    }
    @ResponseBody
    @RequestMapping(value = "/findServiceId")
    public AjaxResult findServiceId(Integer serviceId){
        Service service = serviceService.selectByPrimaryKey(serviceId);
        return new AjaxResult(service);
    }
    @ResponseBody
    @RequestMapping(value = "/delService")
    public AjaxResult delService(Service service){
        int i = serviceService.delService(service);
        return new AjaxResult(i);
    }
    @ResponseBody
    @RequestMapping(value = "/searchAccount")
    public AjaxResult searchAccount(Account account){

        Account account1 = accountService.searchAccount(account);

        return new AjaxResult(account1);
    }
}
