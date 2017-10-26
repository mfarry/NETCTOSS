package com.lanou.controller;

import com.lanou.bean.AdminInfo;
import com.lanou.bean.Cost;
import com.lanou.service.AdminInfoService;
import com.lanou.service.CostService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
@Controller
public class MainController {
    @Resource
    private AdminInfoService adminInfoService;



@RequestMapping(value = "/log")
public String frontPage(){

    return "login";
}


    @RequestMapping(value = "/index")
    public String home(){

        return "index";
    }




@ResponseBody
@RequestMapping(value = "/login")
public AjaxResult login(AdminInfo adminInfo){
    AdminInfo info = adminInfoService.find(adminInfo);
    if (info!=null){
        return new AjaxResult(1);
    } else {
        return new AjaxResult(2);
    }


}

}
