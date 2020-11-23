package com.zk.ssmbuild.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("loginController")
public class LoginController {


    @RequestMapping("login")
    public String login(HttpSession httpSession,String userName, Model model){
        httpSession.setAttribute("userLoginInfo",userName);
        model.addAttribute("userName",userName);
        return "login";
    }


    @RequestMapping("gologin")
    public String goLogin(Model model){
        return "gologin";
    }
}
