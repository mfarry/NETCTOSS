package com.lanou.controller;

import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 17/10/26.
 */
@Controller
public class RoleController {

    @RequestMapping(value = "/rList")
    public String rList() {
        return "/role/role_list";
    }

}
