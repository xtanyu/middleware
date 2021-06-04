package com.example.shirodemo.controller;
import com.example.shirodemo.shiro.ShiroConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;

/**
 * @author: xiaohei
 * @date: 2021/6/3 09:56
 */

@Controller
public class UserController {
    @RequestMapping("user/login")
    public String login(String name, String password, Model model){
        System.out.println("登录入参name:"+name+",password:"+password);
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            System.out.println("登录成功");
            return "index";
        } catch (Exception e) {
            System.out.println("登录失败"+e);
            model.addAttribute("msg", e);
            return "Login";
        }
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("403")
    public String user403(){
        return "403";
    }

    @RequestMapping("user/test1")
    public String test1(){
        return "test1";
    }

    @RequestMapping("user/test2")
    public String test2(){
        return "test2";
    }
}
