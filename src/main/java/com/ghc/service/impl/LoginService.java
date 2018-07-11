package com.ghc.service.impl;

import com.ghc.common.Utils;
import com.ghc.dao.ILogInfoDao;
import com.ghc.dao.IUserDao;
import com.ghc.model.LogInfo;
import com.ghc.model.User;
import com.ghc.service.ILoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService implements ILoginService {
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private ILogInfoDao iLogInfoDao;
    protected final Log logger = LogFactory.getLog(this.getClass());
    @Override
    public boolean loginService(User user, LogInfo logInfo) throws Exception {

        String password = user.getPassword();
        String digestPassword = Utils.digestPassword(user.getPassword());
        user.setPassword(digestPassword);
        //如果能找到用户名及密码
        User user1 = iUserDao.findUserByNameAndPassword(user);
        if(user1!=null){
                /*user.setPassword(password);
                iUserDao.addUser(user);*/
                logInfo.setUserId(user1.getId());
                iLogInfoDao.addLog(logInfo);
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("登录成功日志信息......");
            }
                return true;
        }
        else{
            return false;
        }
    }
}
