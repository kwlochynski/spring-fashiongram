package com.wlochynski.fashiongram.controllers;


import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.validators.UserRegisterValidator;


@Controller
public class RegisterPageController {

	@Autowired
	private UserService userService;
	
	@Autowired
	MessageSource messageSource;
	
	
	@GET
	@RequestMapping(value="/register")
	public String registerForm(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		return "login";
	}
	
	
	@POST
	@RequestMapping(value= "/adduser")
	public String registerAction(User user, BindingResult result, Model model, Locale locale)
	{		
		User userExist = userService.findUserByEmail(user.getEmail());
		
		new UserRegisterValidator().ValidateEmailExist(userExist, result);
		
		new UserRegisterValidator().validate(user, result);
		
		if(!result.hasErrors()) {
			userService.saveUser(user);
			model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));
			model.addAttribute("user", new User());
		}
		
		return "login";
	}
	
}