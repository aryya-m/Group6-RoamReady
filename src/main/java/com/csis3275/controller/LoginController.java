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

	/**
	 * Handles POST requests to the login page.
	 *
	 * @param username the username entered by the user
	 * @param password the password entered by the user
	 * @param session  the current HTTP session
	 * @param model    the model to add attributes to for the view
	 * @return a redirect to the home page if the login is successful, otherwies a
	 *         redirect to the login page
	 */
	@PostMapping("/login")
	public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session,
			Model model) {
		// try catch to log user in based
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

	/**
	 * Handles GET requests to the login page.
	 *
	 * @param model the model to add attributes to for the view
	 * @return the name of the login view
	 */
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("user", new Users());
		return ("login");
	}

	/**
	 * Handles GET requests to the logout URL.
	 *
	 * @param session the current HTTP session
	 * @return redirect to the login page
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // Invalidate the session
		return "redirect:/login"; // Redirect to the login page
	}

	/**
	 * Handles GET requests to the register page.
	 *
	 * @param model the model to add attributes to for the view
	 * @return the name of the registration view
	 */
	@GetMapping("register")
	public String getRegister(Model model) {
		return ("register");
	}

}
