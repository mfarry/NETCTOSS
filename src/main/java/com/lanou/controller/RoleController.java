package com.lanou.controller;

import com.lanou.bean.RoleInfo;
import com.lanou.service.RoleService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/26.
 */
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/rList")
    public String rList() {
        return "/role/role_list";
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllRole")
    public AjaxResult queryAllRole(){

        List<RoleInfo> roleInfoList = roleService.queryAllRole();
        System.out.println(roleInfoList);
        return new AjaxResult(roleInfoList);

    }

}
