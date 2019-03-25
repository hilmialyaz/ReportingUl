package com.huobi.reportingweb.controller;

import com.huobi.reportingweb.dto.LoginResponse;
import com.huobi.reportingweb.dto.User;
import com.huobi.reportingweb.service.LoginService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Controller
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String login(@RequestParam(value = "email", defaultValue = "demo@bumin.com.tr", required = false) String email,
                        @RequestParam(value = "password", defaultValue = "cjaiU8CV", required = false) String password, HttpSession session) {



        UserDetails userDetails = new User("admin","admin",new String[] {"ADMIN"});
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(authentication);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, context);

        LoginResponse response = loginService.login(email,password);
        if(response==null || response.getToken()==null || response.getToken().isEmpty())
            throw new RuntimeException("Login Failed");
        int sessionValidDuration = 10 * 60;
        session.setMaxInactiveInterval(sessionValidDuration);
        return "/admin";
    }

}
