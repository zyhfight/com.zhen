package com.zhen.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
public class AdminInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("admin") != null) {
            System.out.println("session值:"+session.getAttribute("admin") );
        } else {
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("admin") != null) {
            System.out.println("session值:"+session.getAttribute("admin") );
        } else {
            httpServletResponse.sendRedirect("http://localhost:8080/login.html");
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("admin") != null) {
            System.out.println("session值:"+session.getAttribute("admin") );
        } else {
            httpServletResponse.sendRedirect("http://localhost:8080/login.html");
        }
    }

}
