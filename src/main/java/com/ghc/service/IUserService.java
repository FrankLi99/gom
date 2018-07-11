package com.ghc.service;

import com.ghc.model.User;
public interface IUserService {
    User findUserByNameAndPassword(String userName, String password) throws Exception;
    void addUser(User user) throws Exception;
    int queryUserIdByName(String name);
}
