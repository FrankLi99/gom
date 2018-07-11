package com.ghc.service.impl;

import com.ghc.common.Utils;
import com.ghc.dao.IUserDao;
import com.ghc.model.User;
import com.ghc.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements IRegisterService {
    @Autowired
    private IUserDao iUserDao;
    @Override
    public boolean registerUser(User user) throws Exception{
        if(iUserDao.findUserByName(user.getName())==null){
            user.setPassword(Utils.digestPassword(user.getPassword()));
            iUserDao.addUser(user);
            return true;
        }
        else return false;
    }
}
