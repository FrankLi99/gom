package com.ghc.web;

import com.ghc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class JsonTestController {
    @RequestMapping("/jsontest")
    public String jsonTest(HttpServletRequest req){
        return "jsontest";
    }

    @RequestMapping("/jsonrequest")       //因为请求的是json 串所以要添加@RequestBody注解将json对象转为java对象
    public @ResponseBody  User jsonRequest(@RequestBody User user){
           //这个返回值也是要返回json对象，所以要添加@ResponseBody 注解
        return user;
    }

    @RequestMapping("/keyvaluerequest")
    public @ResponseBody User keyValueRequest(User user,HttpServletResponse response){
        //手动指定响应类型
        response.setContentType("application/json;charset=utf8");
        return user;
    }

    @RequestMapping("/angulardemo")
    public String angularDemo(){
        return "angulardemo";
    }

}
