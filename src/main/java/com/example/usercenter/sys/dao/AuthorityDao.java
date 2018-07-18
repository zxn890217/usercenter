package com.example.usercenter.sys.dao;

import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.entity.Authority;
import org.apache.ibatis.annotations.Param;

public interface AuthorityDao extends BaseDao<Authority, Long> {

    public int updateChildrenPathById(@Param("id") long id, @Param("oldPath") String oldPath, @Param("newPath") String newPath);

    public int updateChildrenPathByPath(@Param("id") long id, @Param("oldPath") String oldPath, @Param("newPath") String newPath);

    public int updateChildrenToRoot(Authority entity);
}