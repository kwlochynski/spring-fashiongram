package com.wlochynski.fashiongram.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wlochynski.fashiongram.models.Comment;
import com.wlochynski.fashiongram.models.Post;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.CommentService;
import com.wlochynski.fashiongram.services.FollowService;
import com.wlochynski.fashiongram.services.PostService;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class MainPageController {

	@Autowired
	FollowService followService;

	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	CommentService commentService;

	@GET
	@RequestMapping(value = { "/", "/index" })
	public String mainPage(Model model, RedirectAttributes redirectAttrs) {
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		
		if (followService.countFollowsByFollowerId(user.getUserId()) == 0) {
			return "information";
		} else {
			
			List<Post> followersPosts = postService.findAllByUserIdIn(followService.findFollowingUsers(user.getUserId()));
			model.addAttribute("posts", followersPosts);
			
			List<Integer> userIds = new ArrayList<Integer>();
			List<Integer> postIds = new ArrayList<Integer>();
			for(Post p : followersPosts)
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
			
			return "index";
		}
	}

}
