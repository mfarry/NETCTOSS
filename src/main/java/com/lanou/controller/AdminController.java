package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.AdminInfo;
import com.lanou.bean.Cost;
import com.lanou.bean.ModuleInfo;
import com.lanou.bean.RoleInfo;
import com.lanou.service.AdminInfoService;
import com.lanou.service.RoleService;
import com.lanou.service.impl.RoleServiceImpl;
import com.lanou.utils.AjaxResult;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dllo on 17/10/28.
 */
@Controller
public class AdminController {
    @Resource
    private AdminInfoService adminInfoService;
    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/AdmList")
    public String AdmList() {
        return "/admin/admin_list";
    }

    @RequestMapping(value = "/AdmAdd")
    public String AdmAdd() {

        return "/admin/admin_add";

    }


    @RequestMapping(value = "/AdmMod")
    public String AdmMod() {

        return "/admin/admin_modi";

    }

    //    找到全部
    @ResponseBody
    @RequestMapping(value = "/queryAllAdmin")
    public AjaxResult queryAllAdmin() {
        List<AdminInfo> infos = adminInfoService.queryAllAdmin();
        return new AjaxResult(infos);

    }

    //分页
    @ResponseBody
    @RequestMapping(value = "/pageNumber")
    public PageInfo<AdminInfo> pageInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pagesize") Integer pageSize) {


        return adminInfoService.getPageinfo(pageNo, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/delAdmin")
    public AjaxResult delAdmin(Integer adminId) {
        int i = adminInfoService.deleteByPrimaryKey(adminId);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/delAdminRole")
    public AjaxResult delAdminRole(Integer adminId) {
        int i = adminInfoService.delAdminRole(adminId);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/addAdmin")
    public AjaxResult addAdmin(AdminInfo record) {
        int i = adminInfoService.insert(record);
        return new AjaxResult(i);
    }
//
    @ResponseBody
    @RequestMapping(value = "/searchAdminNameById")
    public AjaxResult searchAdminNameById(AdminInfo record) {
        AdminInfo adminInfo = adminInfoService.searchAdminNameById(record);
        return new AjaxResult(adminInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/addAdminMid")
    public AjaxResult addRole(@RequestParam("adminId") Integer adminId, @RequestParam("roleId") String mle) {

        String[] split = mle.split(",");

        for (int i = 0; i < split.length; i++) {

            adminInfoService.addAdminMid(adminId, Integer.parseInt(split[i]));


        }
        return new AjaxResult(1);

    }

    @ResponseBody
    @RequestMapping(value = "/getAllRoleId")
    public AjaxResult getAllRoleId() {
        List<RoleInfo> roles = roleService.queryAllRole();
        return new AjaxResult(roles);
    }

    //    根据id找到全部
    @ResponseBody
    @RequestMapping(value = "/findAdId")
    public AjaxResult findAdId(HttpServletRequest request, HttpServletResponse response, Integer adminId) {
        AdminInfo info = adminInfoService.selectByPrimaryKey(adminId);
        HttpSession session = request.getSession();
        session.setAttribute("info", info);
        return new AjaxResult(info);
    }


    //    获得session中的数据
    @ResponseBody
    @RequestMapping(value = "/getAdminSession")
    public AjaxResult getAdminSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        AdminInfo info = (AdminInfo) session.getAttribute("info");
        return new AjaxResult(info);
    }

    //    更改admin_info
    @ResponseBody
    @RequestMapping(value = "/updateAdmin")
    public AjaxResult updateAdmin(AdminInfo record) {
        int i = adminInfoService.updateByPrimaryKey(record);
        return new AjaxResult(i);
    }

    //    更改中间表
    @ResponseBody
    @RequestMapping(value = "/updateAdminRole")
    public AjaxResult updateAdminRole(@RequestParam("adminId") Integer adminId, @RequestParam("roleId") String mle) {
        adminInfoService.delAdminRole(adminId);
        String[] split = mle.split(",");

        for (int i = 0; i < split.length; i++) {

            adminInfoService.addAdminMid(adminId, Integer.parseInt(split[i]));


        }
        return new AjaxResult(1);

    }

    //    获得所有的module
    @ResponseBody
    @RequestMapping(value = "/getAllModule")
    public AjaxResult getAllModule() {
        List<ModuleInfo> allModule = adminInfoService.getAllModule();
        return new AjaxResult(allModule);
    }

    @ResponseBody
    @RequestMapping(value = "/hlSearchAdmin")
    public AjaxResult hlSearchAdmin(@RequestParam("moduleId") Integer moduleId, @RequestParam("name") String name) {
        if (name.equals("")) {
            name = null;
        }
        if (moduleId.equals("")) {
            moduleId = null;
        }

        System.out.println(name);
        System.out.println(moduleId);
        List<AdminInfo> infos = adminInfoService.hlSearchAdmin(moduleId, name);
        System.out.println(infos);
        return new AjaxResult(infos);
    }

    @ResponseBody
    @RequestMapping(value = "/nameChange")
    public AjaxResult nameChange(String name){
        System.out.println(name);
     String reg="/^[a-zA-Z\\d\\_\\u2E80-\\u9FFF]{0,50}$/";
        Pattern pattern=Pattern.compile(reg);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()){

            return new AjaxResult(false);
        }else {
            return new AjaxResult(true);
        }

    }
}
