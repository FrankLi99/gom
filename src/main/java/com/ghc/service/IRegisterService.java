package com.ghc.service;

import com.ghc.model.User;

public interface IRegisterService {
    boolean registerUser(User user) throws Exception;
}
