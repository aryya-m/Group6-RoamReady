package com.csis3275.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.csis3275.model.ServiceDao;

@Controller
public class RegistrationController {
    private final ServiceDao serviceDao;
    

    
    public RegistrationController(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("Username") String username, 
                           @RequestParam("email") String email, 
                           @RequestParam("password") String password) {
    	serviceDao.registerUser(username, email, password);
        return "redirect:/login";
    }
}