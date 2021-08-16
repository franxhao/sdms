package com.hqyj.twelve.dao;

import com.hqyj.twelve.pojo.Role;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/16-10:46
 */
public interface RoleDao {
    //通过id获取role角色名
    Role queryRoleById(int id);
}
