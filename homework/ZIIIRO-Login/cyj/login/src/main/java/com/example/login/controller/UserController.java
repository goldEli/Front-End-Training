package com.example.login.controller;

import com.example.login.entity.User;
import com.example.login.mapper.UserMapper;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/")
    public String suc(){
        return "index";
    }

    @RequestMapping("/inter")
    public String inter(){
        return "international";
    }
    @PostMapping(value = "/log")
    @ResponseBody
    public int log(@RequestParam("name") String name,
                   @RequestParam("password") String password){

        System.out.println("前端传入的name："+name);
        System.out.println("前端传入的pswd："+password);
        if ((StringUtils.isEmpty(name)||StringUtils.isEmpty(password))==true){
            return 0;
        }else {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            boolean flag =userService.login(user);
            if(flag == true){
                return 100;
            }else{
                return 200;
            }
        }
    }
    @PostMapping(value = "/regis")
    @ResponseBody
    public int reg(@RequestParam("name") String name,
                       @RequestParam("password") String password){
        System.out.println("前端传入的name："+name);
        System.out.println("前端传入的pswd："+password);
        if ((StringUtils.isEmpty(name)||StringUtils.isEmpty(password))==true){
            return 0;
        }else {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            if (StringUtils.isEmpty(userMapper.findUserByName(name))){
                return userService.insertUser(user);
            }else {
                return 110;
            }
        }
    }


}
