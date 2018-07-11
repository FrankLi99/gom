package com.ghc.dao;

import com.ghc.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    User findUserByNameAndPassword(User user) throws Exception;
    User findUserByName(String userName) throws Exception;
    void addUser(User user) throws Exception;
    int findUserIdByName(String name);
}
