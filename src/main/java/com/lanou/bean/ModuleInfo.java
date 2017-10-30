package com.lanou.bean;

public class ModuleInfo {
    private Integer moduleId;

    private String name;

    private RoleInfo roleInfo;


    @Override
    public String toString() {
        return "ModuleInfo{" +
                "moduleId=" + moduleId +
                ", name='" + name + '\'' +
                ", roleInfo=" + roleInfo +
                '}';
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}