package com.iwl.security.filter;

import com.iwl.security.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil util;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Reading Token from Authorization Header
        String token= request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if(token == null || !token.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        jwt = token.substring(7);

//        if(token !=null) {
            String username= util.getSubject(jwt);
            //if username is not null & Context Authentication must be null
            if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null) {
                UserDetails user= userDetailsService.loadUserByUsername(username);
                boolean isValid=util.isValidToken(jwt, user.getUsername());
                if(isValid) {
                    UsernamePasswordAuthenticationToken authToken=
                            new UsernamePasswordAuthenticationToken(username, user.getPassword(), user.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);

                }
//            }
        }
        filterChain.doFilter(request, response);
    }
}
