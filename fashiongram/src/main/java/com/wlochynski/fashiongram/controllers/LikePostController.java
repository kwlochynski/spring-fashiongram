package com.wlochynski.fashiongram.controllers;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.models.Like;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.LikeService;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class LikePostController {

	@Autowired
	UserService userService;

	@Autowired
	LikeService likeService;

	@POST
	@RequestMapping("like/{postId}")
	public String likePost(@PathVariable int postId)
	{
		// get user
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		
		if(likeService.countByPostIdAndUserId(postId, user.getUserId()) == 0)
		{
			Like like = new Like();
			like.setPostId(postId);
			like.setUserId(user.getUserId());
			likeService.save(like);
		}
		else { 
			likeService.deleteLike(postId, user.getUserId());
		}
		
		
		return "redirect:/discover";
	}
}
