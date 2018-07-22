package com.example.usercenter.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.dao.RoleDao;

import com.example.usercenter.sys.entity.Role;

import java.util.Date;

@Service
public class RoleService extends BaseService<Role, Long> {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private RoleDao roleDao;

    protected BaseDao<Role, Long> getDao(){
            return roleDao;
    }

    @Override
    public boolean insert(Role entity) {
        entity.setCreateTime(new Date());
        if(roleDao.insert(entity)>0){
            if(entity.getAuthorities()!=null && entity.getAuthorities().size()>0)
                roleDao.insertRoleAuthority(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Role entity) {
        roleDao.deleteRoleAuthority(entity.getId());
        if(roleDao.update(entity)>0){
            if(entity.getAuthorities()!=null && entity.getAuthorities().size()>0)
                roleDao.insertRoleAuthority(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean sensitiveUpdate(Role entity) {
        return super.sensitiveUpdate(entity);
    }

    @Override
    public boolean delete(Long id) {
        roleDao.deleteRoleAuthority(id);
        return super.delete(id);
    }
}