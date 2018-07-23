package com.example.usercenter.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.dao.AuthorityDao;

import com.example.usercenter.sys.entity.Authority;
@Service
public class AuthorityService extends BaseService<Authority, Long> {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private AuthorityDao authorityDao;

    protected BaseDao<Authority, Long> getDao(){
            return authorityDao;
    }

    @Override
    public boolean insert(Authority entity) {
        if(authorityDao.insert(entity)>0){
            if(entity.getGroups()!=null && entity.getGroups().size()>0)
                authorityDao.insertAuthorityUserGroup(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Authority entity) {
        if(authorityDao.update(entity)>0){
            authorityDao.deleteAuthorityUserGroup(entity.getId());
            if(entity.getGroups()!=null && entity.getGroups().size()>0)
                authorityDao.insertAuthorityUserGroup(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean sensitiveUpdate(Authority entity) {
        if(authorityDao.sensitiveUpdate(entity)>0){
            if(entity.getGroups()!=null && entity.getGroups().size()>0) {
                authorityDao.deleteAuthorityUserGroup(entity.getId());
                authorityDao.insertAuthorityUserGroup(entity);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        authorityDao.deleteAuthorityUserGroup(id);
        authorityDao.deleteRoleAuthority(id);
        return super.delete(id);
    }
}