package com.example.usercenter.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usercenter.common.base.BaseService;
import com.example.usercenter.common.base.BaseDao;
import com.example.usercenter.sys.dao.UserGroupDao;

import com.example.usercenter.sys.entity.UserGroup;
@Service
public class UserGroupService extends BaseService<UserGroup, Long> {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private UserGroupDao userGroupDao;

    protected BaseDao<UserGroup, Long> getDao(){
            return userGroupDao;
    }

    @Override
    public boolean insert(UserGroup entity) {
        if(entity.getParent()!=null){
            UserGroup parent = userGroupDao.get(entity.getParent().getId());
            if(parent != null){
                entity.setPath(parent.getPath()+parent.getId()+"/");
            }
        }
        if(entity.getPath() == null){
            entity.setPath("/");
        }
        if(userGroupDao.insert(entity)>0){
            if(entity.getAuthorities()!=null && entity.getAuthorities().size()>0)
                userGroupDao.insertAuthorityUserGroup(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(UserGroup entity) {
        UserGroup old = userGroupDao.get(entity.getId());
        String oldPath = old.getPath();
        if(entity.getParent()!=null){
            UserGroup parent = userGroupDao.get(entity.getParent().getId());
            if(parent != null){
                entity.setPath(parent.getPath()+parent.getId()+"/");
            }
        }
        else{
            entity.setPath("/");
        }
        String newPath = entity.getPath();
        if(!oldPath.equals(newPath)){
            userGroupDao.updateChildrenPathByPath(entity.getId(), oldPath, newPath);
        }
        if(userGroupDao.update(entity)>0){
            userGroupDao.deleteAuthorityUserGroup(entity.getId());
            if(entity.getAuthorities()!=null && entity.getAuthorities().size()>0)
                userGroupDao.insertAuthorityUserGroup(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean sensitiveUpdate(UserGroup entity) {
        if(entity.getParent()!=null){
            UserGroup old = userGroupDao.get(entity.getId());
            String oldPath = old.getPath();
            if(entity.getParent()!=null){
                UserGroup parent = userGroupDao.get(entity.getParent().getId());
                if(parent != null){
                    entity.setPath(parent.getPath()+parent.getId()+"/");
                }
            }
            else{
                entity.setPath("/");
            }
            String newPath = entity.getPath();
            if(!oldPath.equals(newPath)){
                userGroupDao.updateChildrenPathByPath(entity.getId(), oldPath, newPath);
            }
        }
        if(userGroupDao.sensitiveUpdate(entity)>0){
            userGroupDao.deleteAuthorityUserGroup(entity.getId());
            if(entity.getAuthorities()!=null && entity.getAuthorities().size()>0)
                userGroupDao.insertAuthorityUserGroup(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if(userGroupDao.delete(id)>0){
            userGroupDao.deleteAuthorityUserGroup(id);
            UserGroup entity = userGroupDao.get(id);
            userGroupDao.updateChildrenToRoot(entity);
            return true;
        }
        return false;
    }
}