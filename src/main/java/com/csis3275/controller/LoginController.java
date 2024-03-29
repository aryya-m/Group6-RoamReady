package com.csis3275.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LoginController {
	@GetMapping("/login")
	public String getLogin(){
		
		return("login");
	}
	
    @GetMapping("register")
	public String getRegister(Model model){
    	
		return("register");
		
	}
	
}
