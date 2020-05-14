package com.wlochynski.fashiongram.controllers;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.models.Post;

@Controller
public class AddPostPageController {

	@GET
	@RequestMapping("/addPost")
	public String showAddPostPage(Model model) {
		Post uploadPost = new Post();
		model.addAttribute("uploadPost",uploadPost);
		return "addPost";
	}
	
}
