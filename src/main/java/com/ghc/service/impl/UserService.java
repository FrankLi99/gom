package com.ghc.service.impl;

import com.ghc.common.Utils;
import com.ghc.dao.IUserDao;
import com.ghc.model.User;
import com.ghc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao iUserDao;

    public IUserDao getiUserDao() {
        return iUserDao;
    }

    public void setiUserDao(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public User findUserByNameAndPassword(String userName, String password) throws Exception {
        User user = new User();
        user.setName(userName);
        // 找之前先把要找的密码 md5 一把，然后跟数据库去比较
        user.setPassword(Utils.digestPassword(password));
        return iUserDao.findUserByNameAndPassword(user);
    }

   @Transactional
   @Override
    public void addUser(User user) throws Exception{
        //存之前也要 md5 加密一把
        user.setPassword(Utils.digestPassword(user.getPassword()));
        iUserDao.addUser(user);
   }

    public int queryUserIdByName(String name){
        return iUserDao.findUserIdByName(name);
    }
}
