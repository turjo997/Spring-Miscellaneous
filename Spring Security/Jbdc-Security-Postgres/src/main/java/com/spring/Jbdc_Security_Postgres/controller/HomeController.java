package com.spring.Jbdc_Security_Postgres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHomePage(){
        return "homepage";
    }

    @GetMapping("/welcome")
    public String getWelcomePage() {
        return "welcomePage";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "adminPage";
    }

    @GetMapping("/employee")
    public String getEmployeePage() {
        return "empPage";
    }

    @GetMapping("/manager")
    public String getManagerPage() {
        return "mgrPage";
    }

    @GetMapping("/common")
    public String getCommonPage() {
        return "commonPage";
    }

    @GetMapping("/accessDenied")
    public String getAccessDeniedPage(){
        return "accessDeniedPage";
    }
}
