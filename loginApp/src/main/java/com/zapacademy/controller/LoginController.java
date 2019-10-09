package com.zapacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.zapacademy.service.RegisterService;


@Controller
@RequestMapping(path="/users")
public class LoginController {

	
	@Autowired
	private RegisterService registerService;
	
	boolean message = false;
	boolean messageExists = false;
	
	@GetMapping(path="/login")
	public String showLoginPage(ModelMap model) {	
        return "login";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showRegisterPage(ModelMap model){
		//model.addAttribute("message", message);
		return "index";
	}
	
	@PostMapping(path="/add")
	public String addUser(ModelMap model, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
		
		if(registerService.insertUser(name, email, password)) {
			message = true;
			model.addAttribute("message", message);
			return "login";
		}else {
			messageExists = true;
			model.addAttribute("messageExists", messageExists);
			return "index";
		}	
	}
}
