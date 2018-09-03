package com.zhen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenyonghe on 2017/1/8.
 */
@Controller
@RequestMapping("/out")
public class LogoutController {

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public  @ResponseBody
    Map<String, Object> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

//        System.out.println(httpServletRequest.getSession().getAttribute("admin"));

        httpServletRequest.getSession().setAttribute("admin",null);

        System.out.println(httpServletRequest.getSession().getAttribute("admin"));

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("data","注销成功");

        return map;

    }

}
