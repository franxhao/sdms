package com.hqyj.twelve.service.impl;

import com.hqyj.twelve.dao.RoleDao;
import com.hqyj.twelve.pojo.Role;
import com.hqyj.twelve.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/16-10:48
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role queryRoleById(int id) {
        return roleDao.queryRoleById(id);
    }
}
