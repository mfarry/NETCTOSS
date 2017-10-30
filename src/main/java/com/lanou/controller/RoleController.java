package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.RoleInfo;
import com.lanou.bean.Service;
import com.lanou.service.RoleService;
import com.lanou.utils.AjaxResult;
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


    @RequestMapping(value = "/rAdd")
    public String rAdd() {
        return "/role/role_add";
    }

    @RequestMapping(value = "/rMod")
    public String rMod() {
        return "/role/role_modi";
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllRole")
    public AjaxResult queryAllRole(){

        List<RoleInfo> roleInfoList = roleService.queryAllRole();

        return new AjaxResult(roleInfoList);

    }



    @ResponseBody
    @RequestMapping(value = "/rolepage")
    public PageInfo<RoleInfo> pageInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pagesize") Integer pageSize) {


        return roleService.getPageinfo(pageNo, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/findModuleInfo")
    public AjaxResult findModuleInfo(String name){
        RoleInfo roleInfo = roleService.findRoleId(name);
        return new AjaxResult(roleInfo);
    }
       @ResponseBody
    @RequestMapping(value = "/addRole")
    public AjaxResult addRole(@RequestParam("roleId") Integer roleId, @RequestParam("moduleId") String mle){

        String[] split = mle.split(",");

        for (int i = 0; i < split.length; i++) {
            roleService.addRole(roleId, Integer.parseInt(split[i]) );

        }
        return new AjaxResult(1);

    }

    @ResponseBody
    @RequestMapping(value = "/addRoleInfo")
    public AjaxResult addRoleInfo(RoleInfo record){

        int insert = roleService.insert(record);
        return new AjaxResult(insert);

    }



    @ResponseBody
    @RequestMapping(value = "/searchNameId")
    public AjaxResult searchNameId(RoleInfo roleInfo){

        RoleInfo info = roleService.searchNameId(roleInfo);
        return new AjaxResult(info);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRole")
    public AjaxResult deleteByPrimaryKey(Integer roleId){
        int i = roleService.deleteByPrimaryKey(roleId);
        return new AjaxResult(i);
    }
    @ResponseBody
    @RequestMapping(value = "/deleteMid")
    public AjaxResult deleteMid(Integer roleId){
        int i = roleService.deleteMid(roleId);
        return new AjaxResult(i);
    }

    @ResponseBody
    @RequestMapping(value = "/getAllRole")
    public AjaxResult getAllRole(HttpServletRequest request, HttpServletResponse response,Integer roleId){


        RoleInfo roleInfo = roleService.selectByPrimaryKey(roleId);
        System.out.println(roleInfo);

        HttpSession session=request.getSession();
        session.setAttribute("roleInfo",roleInfo);
        return new AjaxResult(roleInfo);

    }

    @ResponseBody
    @RequestMapping(value = "/getRoleMod")
    public AjaxResult getRoleMod(HttpServletRequest request,HttpServletResponse response){
        HttpSession session=request.getSession();
        RoleInfo roleInfo = (RoleInfo) session.getAttribute("roleInfo");

        return new AjaxResult(roleInfo);
    }
    @ResponseBody
    @RequestMapping(value = "/updateRoleInfo")
    public AjaxResult updateRoleInfo(RoleInfo roleInfo){
        int i = roleService.updateByPrimaryKey(roleInfo);
        return new AjaxResult(i);

    }


    @ResponseBody
    @RequestMapping(value = "/updateRole")
    public AjaxResult updateRole(@Param("roleId") Integer roleId,@RequestParam("moduleId") String mle){
        roleService.deleteMid(roleId);

        String[] split = mle.split(",");

        for (int i = 0; i < split.length; i++) {
            roleService.addRole(roleId, Integer.parseInt(split[i]) );

        }
        return new AjaxResult(1);
    }

}
