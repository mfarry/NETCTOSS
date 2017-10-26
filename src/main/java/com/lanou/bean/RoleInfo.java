package com.lanou.bean;

import java.util.List;

public class RoleInfo {
    private Integer roleId;

    private String name;

    List<AdminInfo>adminInfoList;

    public List<AdminInfo> getAdminInfoList() {
        return adminInfoList;
    }

    public void setAdminInfoList(List<AdminInfo> adminInfoList) {
        this.adminInfoList = adminInfoList;
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
}