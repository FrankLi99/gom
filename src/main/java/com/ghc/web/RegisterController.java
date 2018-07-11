package com.ghc.web;

import com.ghc.model.User;
import com.ghc.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class RegisterController {
    @Autowired
    private IRegisterService registerService;
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/registerUser")
    public String registerUser(User user, HttpServletRequest req) throws Exception{
        Boolean emptyFlag=StringUtils.isEmpty(user.getName())
                || StringUtils.isEmpty(user.getPassword())
                ||StringUtils.isEmpty(user.getEmail());
        if(!emptyFlag){
            // 此处应该要做用户信息规则检测，长度，密码复杂度，邮箱规则等

            String regIP = req.getRemoteHost();
            Date regDate = new Date();
            user.setRegDate(regDate);
            user.setRegIP(regIP);
            boolean registerFlag = registerService.registerUser(user);
            if(!registerFlag){req.setAttribute("alreadyExists","用户名已存在");
                                return "register";
            }
            return "success";
        }
        else{
            req.setAttribute("errorMsg","注册信息均不能为空!");
            return "forward:/register";
        }

    }
}
