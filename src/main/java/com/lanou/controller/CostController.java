package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.service.CostService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/21.
 */
@Controller
public class CostController {
    @Resource
    private CostService costService;

    @RequestMapping(value = "/fList")
    public String fList() {

        return "/fee/fee_list";
    }

    @RequestMapping(value = "/fAad")
    public String fAdd() {

        return "/fee/fee_add";
    }

    @RequestMapping(value = "/fMod")
    public String fMod() {

        return "/fee/fee_modi";
    }

    @RequestMapping(value = "/nopower")
    public String noPower() {

        return "nopower";
    }

    @RequestMapping(value = "/detail")
    public String showDetail() {

        return "/fee/fee_detail";
    }


    @ResponseBody
    @RequestMapping(value = "/findAll")
    public AjaxResult findAll() {
        List<Cost> all = costService.findAll();

        return new AjaxResult(all);

    }


    @ResponseBody
    @RequestMapping(value = "/insertCost")
    public AjaxResult insert(Cost record) {

        record.setStatus("0");
        record.setCreatime(new Date());


        int insert = costService.insert(record);

        return new AjaxResult(insert);
    }


    @ResponseBody
    @RequestMapping(value = "/delCost")
    public AjaxResult deleteByPrimaryKey(Integer costId) {

        int i = costService.deleteByPrimaryKey(costId);

        return new AjaxResult(i);

    }

    @ResponseBody
    @RequestMapping(value = "/allCost")
    public AjaxResult all(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Cost all = (Cost) session.getAttribute("cost");

        return new AjaxResult(all);

    }



    @ResponseBody
    @RequestMapping(value = "/findById")
    public AjaxResult selectByPrimaryKey(HttpServletRequest request, Integer costId) {

        HttpSession session = request.getSession();
        Cost cost = costService.selectByPrimaryKey(costId);
        session.setAttribute("cost", cost);

        return new AjaxResult(cost);
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public AjaxResult updateByPrimaryKey(Cost record) {

        int i = costService.updateByPrimaryKey(record);
        return new AjaxResult(i);


    }

    @ResponseBody
    @RequestMapping(value = "/start")
    public AjaxResult start(Cost cost) {
        int i = costService.update(cost);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/insertStartTime")
    public AjaxResult insertStartTime(Cost cost) {

        int i = costService.updateStartTime(cost);
        return new AjaxResult(i);

    }

    @ResponseBody
    @RequestMapping(value = "/findId")
    public AjaxResult findId(Integer costId) {
        Cost cost = costService.selectByPrimaryKey(costId);
        return new AjaxResult(cost);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllById")
    public AjaxResult findAllById(HttpServletRequest request, Integer costId){

        HttpSession session = request.getSession();
        Cost cost = costService.selectByPrimaryKey(costId);
        session.setAttribute("costList", cost);

        return new AjaxResult(cost);
    }

    @ResponseBody
    @RequestMapping(value = "/getId")
    public AjaxResult getId(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Cost list = (Cost) session.getAttribute("costList");


        return new AjaxResult(list);


    }



    @ResponseBody
    @RequestMapping(value = "/pageinfo")
    public PageInfo<Cost> pageInfo(@RequestParam("pageNo") Integer pageNo ,@RequestParam("pagesize") Integer pageSize){


        return costService.getPageinfo(pageNo,pageSize);
    }



}
