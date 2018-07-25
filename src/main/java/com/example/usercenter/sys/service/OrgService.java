package com.example.usercenter.sys.service;

import com.example.usercenter.sys.entity.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.dao.OrgDao;

import com.example.usercenter.sys.entity.Org;
@Service
public class OrgService extends BaseService<Org, Long> {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private OrgDao orgDao;

    protected BaseDao<Org, Long> getDao(){
            return orgDao;
    }

    @Override
    public boolean insert(Org entity) {
        if(entity.getParent()!=null){
            Org parent = orgDao.get(entity.getParent().getId());
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
    public boolean update(Org entity) {
        Org old = orgDao.get(entity.getId());
        String oldPath = old.getPath();
        if(entity.getParent()!=null){
            Org parent = orgDao.get(entity.getParent().getId());
            if(parent != null){
                entity.setPath(parent.getPath()+parent.getId()+"/");
            }
        }
        else{
            entity.setPath("/");
        }
        String newPath = entity.getPath();
        if(!oldPath.equals(newPath)){
            orgDao.updateChildrenPathByPath(entity.getId(), oldPath, newPath);
        }
        return super.update(entity);
    }

    @Override
    public boolean sensitiveUpdate(Org entity) {
        if(entity.getParent()!=null){
            Org old = orgDao.get(entity.getId());
            String oldPath = old.getPath();
            if(entity.getParent()!=null){
                Org parent = orgDao.get(entity.getParent().getId());
                if(parent != null){
                    entity.setPath(parent.getPath()+parent.getId()+"/");
                }
            }
            else{
                entity.setPath("/");
            }
            String newPath = entity.getPath();
            if(!oldPath.equals(newPath)){
                orgDao.updateChildrenPathByPath(entity.getId(), oldPath, newPath);
            }
        }
        return super.sensitiveUpdate(entity);
    }

    @Override
    public boolean delete(Long id) {
        return super.delete(id);
    }
}