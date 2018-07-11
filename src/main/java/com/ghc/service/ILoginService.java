package com.ghc.service;

import com.ghc.model.User;
import com.ghc.model.LogInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface ILoginService {
   boolean loginService(User user, LogInfo logInfo) throws Exception ;
}
