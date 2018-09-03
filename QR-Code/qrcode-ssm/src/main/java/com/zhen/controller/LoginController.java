package com.zhen.controller;

import com.zhen.model.User;
import com.zhen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenyonghe on 2017/1/8.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "index",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> index(@RequestParam("username") String userName, @RequestParam("password") String password, ModelMap model,HttpServletRequest httpServletRequest){
        System.out.println(userName+"-"+password);

        String result = login(userName,password);
        Map<String, Object> map = new HashMap<String, Object>();

        if(result.equals("登陆成功")){
            httpServletRequest.getSession().setAttribute("admin","success");
            map.put("data","登陆成功");
        }else{
            map.put("data",result);
        }

        return map;
    }

    private String login(String userName,String password){

         User user = userService.selectUserByUserId(userName);

         if(user==null){
            return "该用户不存在";
         }else if(!user.getPassword().equals(password)){
             return "密码不正确";
         }else{
             return "登陆成功";
         }

    }
}
