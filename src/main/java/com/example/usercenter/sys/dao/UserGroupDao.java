package com.example.usercenter.sys.dao;

import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.entity.UserGroup;
import org.apache.ibatis.annotations.Param;

public interface UserGroupDao extends BaseDao<UserGroup, Long> {

    public int updateChildrenPathById(@Param("id") long id, @Param("oldPath") String oldPath, @Param("newPath") String newPath);

    public int updateChildrenPathByPath(@Param("id") long id, @Param("oldPath") String oldPath, @Param("newPath") String newPath);

    public int updateChildrenToRoot(UserGroup entity);
}