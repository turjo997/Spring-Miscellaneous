package com.iwl.multi_tenant_mvc.controller;

import com.iwl.multi_tenant_mvc.TenantContext;
import com.iwl.multi_tenant_mvc.domain.User;
import com.iwl.multi_tenant_mvc.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

//    private final List<String> tenants = List.of("tenant_1", "tenant_2");

    @Autowired
    private List<String> tenants;

    @GetMapping("/login")
    public String loginForm(Model model) {
//        List<String> tenants = masterJdbcTemplate.queryForList("SELECT tenant_id FROM tenant_master WHERE active = TRUE", String.class);
        model.addAttribute("user", new User());
        model.addAttribute("tenants", tenants);
        return "auth/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute User user, @RequestParam("tenant") String tenant, Model model) {
//        List<String> tenants = masterJdbcTemplate.queryForList("SELECT tenant_id FROM tenant_master WHERE active = TRUE", String.class);
        TenantContext.setCurrentTenant(tenant);
        Optional<User> userOpt = userRepository.findByUsername(user.getUsername());
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(user.getPassword())) {
            model.addAttribute("tenant", tenant);
            model.addAttribute("message", "Login successful for tenant: " + TenantContext.getCurrentTenant());
            return "auth/success";
        } else {
            model.addAttribute("error", "Invalid credentials");
            model.addAttribute("tenants", tenants);
            return "auth/login";
        }
    }
}

