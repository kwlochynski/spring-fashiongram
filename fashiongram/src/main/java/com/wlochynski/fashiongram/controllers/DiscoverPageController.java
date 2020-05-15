package com.wlochynski.fashiongram.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.models.Post;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.PostService;
import com.wlochynski.fashiongram.services.UserService;

@Controller
public class DiscoverPageController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@GET
	@RequestMapping("discover")
	public String showDiscoverPage(Model model)
	{
		
		List<Post> newPosts = postService.findAll();
		model.addAttribute("newPosts", newPosts);
		List<Integer> userIds = new ArrayList<Integer>();
		for(Post p : newPosts)
		{
			userIds.add(p.getUserId());
		}
		
		List<User> userList = userService.findAllById(userIds);
		
		model.addAttribute("userList",userList);

		
		return "discover";
	}
	
}
