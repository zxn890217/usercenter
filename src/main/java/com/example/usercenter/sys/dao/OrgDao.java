package com.example.usercenter.sys.dao;

import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.entity.Org;
import org.apache.ibatis.annotations.Param;

public interface OrgDao extends BaseDao<Org, Long> {

    public int updateChildrenPathById(@Param("id") long id, @Param("oldPath") String oldPath, @Param("newPath") String newPath);

    public int updateChildrenPathByPath(@Param("id") long id, @Param("oldPath") String oldPath, @Param("newPath") String newPath);

    public int updateChildrenToRoot(Org entity);
}