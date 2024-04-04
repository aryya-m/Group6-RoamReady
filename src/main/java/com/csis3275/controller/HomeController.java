package com.csis3275.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.csis3275.model.Users;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    /**
     * Methods handle requests to the home, converter, and emergency details page.
     *
     * @param session the current HTTP session
     * @param model   the model to add the user to for the view to access if needed
     * @return the name of the view to render, or a redirect to the login page if there's no user in the session
     */


    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("user"); // Get the user from the session
        if (user == null) {
            return "redirect:/login"; // Redirect to the login page if there's no user in the session
        } else {
            model.addAttribute("user", user); // Add the user to the model
            return "homeView"; // Return the home view
        }

    }

    @GetMapping("/converter")
    public String currencyConverter(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("user"); // Get the user from the session
        if (user == null) {
            return "redirect:/login"; // Redirect to the login page if there's no user in the session
        } else {
            model.addAttribute("user", user); // Add the user to the model
            return "currency"; // Return the currency converter
        }

    }

    @GetMapping("/emergency")
    public String emergencyDetails(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("user"); // Get the user from the session
        if (user == null) {
            return "redirect:/login"; // Redirect to the login page if there's no user in the session
        } else {
            model.addAttribute("user", user); // Add the user to the model
            return "emergency"; // Return the emergency view
        }

    }

    @GetMapping("/experiences")
    public String experiences(HttpSession session, Model model) {
        Users user = (Users) session.getAttribute("user"); // Get the user from the session
        if (user == null) {
            return "redirect:/login"; // Redirect to the login page if there's no user in the session
        } else {
            model.addAttribute("user", user); // Add the user to the model
            return "experience"; // Return the experience view
        }

    }

}
