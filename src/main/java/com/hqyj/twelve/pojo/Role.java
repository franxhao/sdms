package com.hqyj.twelve.pojo;

import java.io.Serializable;

/**
 * 角色POJO
 * 对应表role
 */
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
