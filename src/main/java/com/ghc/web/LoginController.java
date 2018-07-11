package com.ghc.web;

import com.ghc.model.LogInfo;
import com.ghc.model.User;
import com.ghc.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class LoginController {
    @Autowired
    private ILoginService loginService;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginCheck")
    public @ResponseBody Map<String,String> loginCheck(@RequestBody User user, Model model, HttpServletRequest req) throws Exception{
        Map<String, String> map = new HashMap<>();
        String result;
        String loginIP = req.getRemoteHost();
        Date loginDate = new Date();
        LogInfo logInfo = new LogInfo();
        logInfo.setLoginDate(loginDate);
        logInfo.setLoginIP(loginIP);
        Boolean emptyFlag = StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword());
        //int i=1/0;
        if(emptyFlag||!loginService.loginService(user,logInfo)){
            model.addAttribute("error","用户名或密码错误！");
            result="false";
            map.put("error","用户名或密码错误！");
            //return "forward:login";
        }
        else{
             result="true";
             req.getSession().setAttribute("user",user);
             //return "forward:/items/queryItems";
        }
        map.put("result", result);
       // model.addAttribute("result",result);
        return map;
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
