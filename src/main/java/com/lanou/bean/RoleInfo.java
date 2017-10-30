package com.lanou.bean;

import java.util.List;

public class RoleInfo {
    private Integer roleId;

    private String name;


    private AdminInfo adminInfo;
    List<ModuleInfo>moduleInfoList;

    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

    public List<ModuleInfo> getModuleInfoList() {
        return moduleInfoList;
    }

    public void setModuleInfoList(List<ModuleInfo> moduleInfoList) {
        this.moduleInfoList = moduleInfoList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", moduleInfoList=" + moduleInfoList +
                '}';
    }
}