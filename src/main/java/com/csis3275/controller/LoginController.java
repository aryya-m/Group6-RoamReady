package com.csis3275.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.model.ServiceDao;
import com.csis3275.model.Users;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private ServiceDao serviceDao;

	@PostMapping("/login")
	public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
	//try catch to log user in based 
		try {
			Users users = serviceDao.loginUser(username, password);
			session.setAttribute("user", users); // Store the user in the session
			model.addAttribute(username, users.getUsername());
			return "redirect:/"; // Redirect to the home page
		} catch (IllegalArgumentException e) {
			model.addAttribute("user", new Users());
			return "login"; // Redirect back to the login page if the login fails
		}
	}

	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("user", new Users());
		return ("login");
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
    session.invalidate(); // Invalidate the session
    return "redirect:/login"; // Redirect to the login page
}

	@GetMapping("register")
	public String getRegister(Model model) {

		return ("register");

	}

}
