package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.bean.Service;
import com.lanou.service.AccountService;
import com.lanou.service.CostService;
import com.lanou.service.ServiceService;
import com.lanou.utils.AjaxResult;
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
 * Created by dllo on 17/10/25.
 */
@Controller
public class ServiceController {

    @Resource
    private ServiceService serviceService;
    @Resource
    private AccountService accountService;
    @Resource
    private CostService costService;

    @RequestMapping(value = "/sList")
    public String sList() {
        return "/service/service_list";

    }


    @RequestMapping(value = "/sMod")
    public String sMod() {
        return "/service/service_modi";

    }

    @RequestMapping(value = "/sAdd")
    public String sAdd() {
        return "/service/service_add";

    }

    @RequestMapping(value = "/sDetail")
    public String sDetail() {
        return "/service/service_detail";

    }


    @ResponseBody
    @RequestMapping(value = "/queryAllService")
    public AjaxResult queryAllService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.queryAllService();
        HttpSession session = request.getSession();
        session.setAttribute("service", serviceList);
        return new AjaxResult(serviceList);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAccount")
    public AjaxResult queryAccount(Integer accountId) {
        List<Account> accountList = serviceService.queryAccount(accountId);

        return new AjaxResult(accountList);

    }

    @ResponseBody
    @RequestMapping(value = "/servicepage")
    public PageInfo<Service> pageInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pagesize") Integer pageSize) {


        return serviceService.getPageinfo(pageNo, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/updateServiceFee")
    public AjaxResult updateServiceFee(Service service) {
        int i = serviceService.updateById(service);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/delServicePause")
    public AjaxResult delServicePause(Service service) {
        int i = serviceService.updatePause(service);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/servicePause")
    public AjaxResult servicePause(Service service) {
        System.out.println(service.getStatus());
        int i = serviceService.servicePause(service);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/findServiceId")
    public AjaxResult findServiceId(Integer serviceId) {
        Service service = serviceService.selectByPrimaryKey(serviceId);
        return new AjaxResult(service);
    }

    @ResponseBody
    @RequestMapping(value = "/delService")
    public AjaxResult delService(Service service) {
        int i = serviceService.delService(service);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/searchAccount")
    public AjaxResult searchAccount(HttpServletRequest request, HttpServletResponse response, Account account) {
        HttpSession session = request.getSession();
        Account account1 = accountService.searchAccount(account);
        session.setAttribute("account", account1);
        return new AjaxResult(account1);
    }

    @ResponseBody
    @RequestMapping(value = "/getService")
    public AjaxResult getService(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        return new AjaxResult(account);

    }


    @ResponseBody
    @RequestMapping(value = "/getCostType")
    public AjaxResult getCostType() {
        List<Cost> costList = costService.findAll();
        return new AjaxResult(costList);

    }

    @ResponseBody
    @RequestMapping(value = "/addService")
    public AjaxResult insertService(Service service) {
        int insert = serviceService.insert(service);
        return new AjaxResult(insert);

    }

    @ResponseBody
    @RequestMapping(value = "/searchService")
    public AjaxResult searchService(
            @RequestParam("idcardNo") String idcardNo,
            @RequestParam("osUsername") String osUsername,
            @RequestParam("unixHost") String unixHost,
            @RequestParam("status") String status
    ) {


        if (osUsername.equals("")) {
            osUsername = null;
        }
        if (unixHost.equals("")) {
            unixHost = null;
        }
        if (idcardNo.equals("")) {
            idcardNo = null;
        }

        if (status.equals("")) {
            status = null;
        }

        List<Service> serviceList = serviceService.searchService(osUsername, unixHost, idcardNo, status);

        return new AjaxResult(serviceList);

    }

    @ResponseBody
    @RequestMapping(value = "/getIdcardById")
    public AjaxResult getIdcardById(Integer accountId) {

        Account account = accountService.selectByPrimaryKey(accountId);
        return new AjaxResult(account);
    }
@ResponseBody
    @RequestMapping(value = "/serviceDetailById")
    public AjaxResult serviceDetailById(HttpServletRequest request,HttpServletResponse response,Integer serviceId){
    Service service = serviceService.selectByPrimaryKey(serviceId);
    HttpSession session=request.getSession();
    session.setAttribute("allService",service);
    return new AjaxResult(service);
}



    @ResponseBody
    @RequestMapping(value = "/getServiceDetail")
    public AjaxResult getServiceDetail(HttpServletRequest request,HttpServletResponse response){

        HttpSession session=request.getSession();
        Service service = (Service) session.getAttribute("allService");
        return new AjaxResult(service);
    }

}
