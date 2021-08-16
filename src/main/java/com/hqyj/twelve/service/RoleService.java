package com.hqyj.twelve.service;

import com.hqyj.twelve.pojo.Role;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/16-10:47
 */
public interface RoleService {
    //通过id获取Role
    Role  queryRoleById(int id);
}
