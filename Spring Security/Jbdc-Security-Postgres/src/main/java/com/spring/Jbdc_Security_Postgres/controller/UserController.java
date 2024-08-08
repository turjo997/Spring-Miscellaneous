package com.spring.Jbdc_Security_Postgres.controller;

import com.spring.Jbdc_Security_Postgres.entity.User;
import com.spring.Jbdc_Security_Postgres.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/register")
    private String register(){
        return "registerUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user , Model model){
        Long id = userService.saveUser(user);
        String message = "User '"+id+"' saved successfully !";
        model.addAttribute("msg" , message);
        return "registerUser";
    }
}
