package com.iwl.multi_tenant_mvc.controller;

import com.iwl.multi_tenant_mvc.TenantContext;
import com.iwl.multi_tenant_mvc.domain.User;
import com.iwl.multi_tenant_mvc.repo.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/login/{tenant}")
    public String loginForm(@PathVariable String tenant, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("TENANT", tenant);
        model.addAttribute("user", new User());
//        model.addAttribute("tenants", tenants);
        model.addAttribute("tenant", tenant);
        return "auth/login";

    }

    @PostMapping("/login/{tenant}")
    public String login(@ModelAttribute User user, @PathVariable ("tenant") String tenant, HttpServletRequest request, Model model) {
        TenantContext.setCurrentTenant(tenant);
        Optional<User> userOpt = userRepository.findByUsername(user.getUsername());
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(user.getPassword())) {
            HttpSession session = request.getSession(true);
            session.setAttribute("TENANT", tenant);
            model.addAttribute("tenant", tenant);
            model.addAttribute("message", "Login successful for tenant: " + TenantContext.getCurrentTenant());
            return "auth/success";
        } else {
            model.addAttribute("error", "Invalid credentials");
            model.addAttribute("tenant", tenant);
//            model.addAttribute("tenants", tenants);
            return "auth/login";
        }
    }
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate(); // clear tenant + user data
//        }
//        TenantContext.clear();
//        return "redirect:/auth/login?logout"; // redirect to login page
//    }

    @GetMapping("/logout/{tenantId}")
    public String logout(@PathVariable String tenantId, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // clear user + tenant data from session
        }
        TenantContext.clear(); // clear thread-local tenant

        return "redirect:/auth/login/" + tenantId + "?logout";
    }


}

