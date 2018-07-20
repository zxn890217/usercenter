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
        if(entity.getParent()!=null){
            Authority parent = authorityDao.get(entity.getParent().getId());
            if(parent != null){
                entity.setPath(parent.getPath()+parent.getId()+"/");
            }
        }
        if(entity.getPath() == null){
            entity.setPath("/");
        }
        return super.insert(entity);
    }

    @Override
    public boolean update(Authority entity) {
        /*Authority old = authorityDao.get(entity.getId());
        String oldPath = old.getPath();
        if(entity.getParent()!=null){
            Authority parent = authorityDao.get(entity.getParent().getId());
            if(parent != null){
                entity.setPath(parent.getPath()+parent.getId()+"/");
            }
        }
        else{
            entity.setPath("/");
        }
        String newPath = entity.getPath();
        if(!oldPath.equals(newPath)){
            authorityDao.updateChildrenPathByPath(entity.getId(), oldPath, newPath);
        }*/
        return super.update(entity);
    }

    @Override
    public boolean sensitiveUpdate(Authority entity) {
        /*if(entity.getParent()!=null){
            Authority old = authorityDao.get(entity.getId());
            String oldPath = old.getPath();
            if(entity.getParent()!=null){
                Authority parent = authorityDao.get(entity.getParent().getId());
                if(parent != null){
                    entity.setPath(parent.getPath()+parent.getId()+"/");
                }
            }
            else{
                entity.setPath("/");
            }
            String newPath = entity.getPath();
            if(!oldPath.equals(newPath)){
                authorityDao.updateChildrenPathByPath(entity.getId(), oldPath, newPath);
            }
        }*/
        return super.sensitiveUpdate(entity);
    }

    @Override
    public boolean delete(Long id) {
        /*Authority entity = authorityDao.get(id);
        authorityDao.updateChildrenToRoot(entity);*/
        return super.delete(id);
    }
}