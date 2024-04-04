package com.csis3275.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.csis3275.model.ServiceDao;

@Controller
public class RegistrationController {
    private final ServiceDao serviceDao;

    /**
     * Constructor for RegistrationController with a given data access object.
     *
     * @param serviceDao the ServiceDao to use for user registration
     */
    public RegistrationController(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    /**
     * Handles POST requests to the registration page.
     *
     * @param username the username entered by the user
     * @param email    the email entered by the user
     * @param password the password entered by the user
     * @return a redirect to the login page after successful registration
     * 
     * No form validation is done
     */
    @PostMapping("/register")
    public String registerUser(@RequestParam("Username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        serviceDao.registerUser(username, email, password);
        return "redirect:/login";
    }
}