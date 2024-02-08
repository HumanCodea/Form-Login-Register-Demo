package com.thandeptrai.FormLoginDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thandeptrai.FormLoginDemo.model.Users;
import com.thandeptrai.FormLoginDemo.service.UserService;

@Controller
@RequestMapping(path = "")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String LoginUser(){
        return "loginUser";
    }

    @GetMapping("/register")
    public String registerUser(){
        return "registerUser";
    }

    @GetMapping("/home")
    public String Home(){
        return "home";
    }

    @PostMapping("/save")
    public String SaveUser(@ModelAttribute Users users){
        userService.saveUser(users);
        return "redirect:/register?successfully";
    }
}
