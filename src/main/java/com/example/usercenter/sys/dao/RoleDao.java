package com.example.usercenter.sys.dao;

import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.entity.Role;

public interface RoleDao extends BaseDao<Role, Long> {
    public int insertRoleAuthority(Role entity);

    public int deleteRoleAuthority(Role entity);
}