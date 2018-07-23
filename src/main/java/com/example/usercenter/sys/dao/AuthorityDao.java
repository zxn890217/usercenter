package com.example.usercenter.sys.dao;

import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.entity.Authority;
import org.apache.ibatis.annotations.Param;

public interface AuthorityDao extends BaseDao<Authority, Long> {

    public int insertAuthorityUserGroup(Authority entity);

    public int deleteAuthorityUserGroup(long id);

    public int deleteRoleAuthority(long id);
}