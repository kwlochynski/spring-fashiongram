package com.wlochynski.fashiongram.controllers;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.models.Post;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class AddPostPageController {

	@Autowired
	UserService userService;
	
	@GET
	@RequestMapping("/addPost")
	public String showAddPostPage(Model model) {
		Post uploadPost = new Post();
		model.addAttribute("uploadPost",uploadPost);
		
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		
		return "addPost";
	}
	
}
