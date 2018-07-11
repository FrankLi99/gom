package com.ghc.exception;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        CustomException customException;

        if(e instanceof CustomException){
            customException=(CustomException)e;
        }
        else{ customException=new CustomException("未知错误!");
        }
        String message = customException.getMessage();
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("message",message);
        return modelAndView;
    }
}
