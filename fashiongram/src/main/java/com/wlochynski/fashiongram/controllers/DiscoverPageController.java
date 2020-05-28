 package com.wlochynski.fashiongram.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.dto.PostLikesDTO;
import com.wlochynski.fashiongram.models.Comment;
import com.wlochynski.fashiongram.models.Post;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.CommentService;
import com.wlochynski.fashiongram.services.LikeService;
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
	LikeService likeService;
	
	@Autowired
	CommentService commentService;
	
	@GET
	@RequestMapping("discover")
	public String showDiscoverPage(Model model)
	{
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		
		List<Post> newPosts = postService.findAllByOrderByIdDesc();

		List<Integer> userIds = new ArrayList<Integer>();
		List<Integer> postIds = new ArrayList<Integer>();
		for(Post p : newPosts)
		{
			userIds.add(p.getUserId());
			postIds.add(p.getId());
		}
		
		List<PostLikesDTO> postsLikesDTO = likeService.getPostsLikesDTO(postIds);


		List<Integer> userLikes = likeService.getUserLikes(user.getUserId(), postIds);
		
		model.addAttribute("userLikes",userLikes);
		
		List<User> userList = userService.findAllById(userIds);
		
		
		for(Post p : newPosts)
		{
			for(User u : userList)
			{
				if(p.getUserId() == u.getUserId())
				{
					p.setPostedUserAvatar(u.getAvatarUrl());
					p.setPostedUserName(u.getName());
					break;
				}
			}
			for(PostLikesDTO pl : postsLikesDTO)
			{
				if(p.getId() == pl.getPostId())
				{
					p.setNumberOfLikes(pl.getNumberOfLikes());
					break;
				}
			}
		}
		model.addAttribute("posts", newPosts);

		//comments
		
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
