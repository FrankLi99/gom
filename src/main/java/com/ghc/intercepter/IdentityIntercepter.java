package com.ghc.intercepter;

import com.ghc.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdentityIntercepter implements HandlerInterceptor {
    protected Log logger = LogFactory.getLog(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user =(User)httpServletRequest.getSession().getAttribute("user");
        if(logger.isDebugEnabled()){
            logger.debug(httpServletRequest);
        }
        String url = (String) httpServletRequest.getRequestURI();
        if(url.indexOf("login")>=0 ||
                url.indexOf("loginCheck")>=0||url.indexOf("register")>=0||
                (user!=null)) return true;
        else{
            httpServletRequest.setAttribute("error","用户未登录请登录后进行操作");
            httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest,httpServletResponse);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("IdentityIntercepter postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("IdentityIntercepter afterHandle...");
    }
}
