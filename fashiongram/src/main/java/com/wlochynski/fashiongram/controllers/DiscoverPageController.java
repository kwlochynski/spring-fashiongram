package com.wlochynski.fashiongram.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.models.Comment;
import com.wlochynski.fashiongram.models.Post;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.CommentService;
import com.wlochynski.fashiongram.services.PostService;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class DiscoverPageController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CommentService commentService;
	
	@GET
	@RequestMapping("discover")
	public String showDiscoverPage(Model model)
	{
		List<Post> newPosts = postService.findAllByOrderByIdDesc();
		model.addAttribute("newPosts", newPosts);
		List<Integer> userIds = new ArrayList<Integer>();
		List<Integer> postIds = new ArrayList<Integer>();
		for(Post p : newPosts)
		{
			userIds.add(p.getUserId());
			postIds.add(p.getId());
		}
		List<User> userList = userService.findAllById(userIds);
		model.addAttribute("userList",userList);
		
		List<Comment> commentList = commentService.findAllByPostIdInOrderByIdDesc(postIds);
		model.addAttribute("commentList",commentList);
		
		List<Integer> commentUserIds = new ArrayList<Integer>();
		for(Comment c : commentList)
		{
			commentUserIds.add(c.getUserId());
		}
		
		List<User> commentUserList = userService.findAllById(commentUserIds);
		model.addAttribute("commentUserList",commentUserList);
		
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);

		return "discover";
	}
	
}
