package com.wlochynski.fashiongram.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.wlochynski.fashiongram.dto.PostLikesDTO;
import com.wlochynski.fashiongram.models.Comment;
import com.wlochynski.fashiongram.models.Post;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.CommentService;
import com.wlochynski.fashiongram.services.FollowService;
import com.wlochynski.fashiongram.services.LikeService;
import com.wlochynski.fashiongram.services.PostService;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class ProfilePageController {

	@Autowired
	UserService userService;

	@Autowired
	PostService postService;
	
	@Autowired
	FollowService followService;
	
	@Autowired
	LikeService likeService;
	
	@Autowired
	CommentService commentService;

	@GET
	@RequestMapping("profile")
	public String showProfilePage(Model model) {
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);

		// get all user posts
		List<Post> listOfUserPosts = postService.findAllByUserId(user.getUserId());
		model.addAttribute("listOfUserPosts", listOfUserPosts);

		model.addAttribute("ifLoggedUserProfile", true);

		model.addAttribute("numberOfFollowers", followService.countFollowsByUserId(user.getUserId()));

		return "profile";
	}

	@GET
	@RequestMapping("profile/{profileId}")
	public String showUserProfilePage(@PathVariable int profileId, Model model) {
		String userEmail = UserUtilites.getLoggedUser();
		User loggedUser = userService.findUserByEmail(userEmail);
		
		if (loggedUser.getUserId() != profileId) {
			User user = userService.findUserByUserId(profileId);
			model.addAttribute("user", user);

			List<Post> listOfUserPosts = postService.findAllByUserId(user.getUserId());
						
			model.addAttribute("listOfUserPosts", listOfUserPosts);

			model.addAttribute("ifLoggedUserProfile", false);
			
			model.addAttribute("loggedUser",loggedUser);
			
			if(followService.countFollowsByUserIdAndFollowerId(user.getUserId(),loggedUser.getUserId()) == 0)
			{
				model.addAttribute("isFollowing", false);
			}
			else {
				model.addAttribute("isFollowing", true);
			}
			
			//add model with number of user followers
			model.addAttribute("numberOfFollowers", followService.countFollowsByUserId(user.getUserId()));

			return "profile";
		}
		else {
			return "redirect:/profile";
		}
	}
	
	@GET
	@RequestMapping("/profile/post/{postId}")
	public String displayImage(Model model, @PathVariable int postId) {
		String userEmail = UserUtilites.getLoggedUser();
		User loggedUser = userService.findUserByEmail(userEmail);
		model.addAttribute("loggedUser", loggedUser);

		model.addAttribute("postId",postId);
		
		Post post = postService.findOneById(postId);
		model.addAttribute("displayUser",userService.findUserByUserId(post.getUserId()));
		
		List<Post> userPosts = postService.findAllByUserId(post.getUserId());

		List<Integer> postIds = new ArrayList<Integer>();
		for(Post p : userPosts)
		{
			postIds.add(p.getId());
		}
		
		List<PostLikesDTO> postsLikesDTO = likeService.getPostsLikesDTO(postIds);

		List<Integer> userLikes = likeService.getUserLikes(loggedUser.getUserId(), postIds);
		
		model.addAttribute("userLikes",userLikes);
		
		for(Post p : userPosts)
		{
			for(PostLikesDTO pl : postsLikesDTO)
			{
				if(p.getId() == pl.getPostId())
				{
					p.setNumberOfLikes(pl.getNumberOfLikes());
					break;
				}
			}
		}
		
		model.addAttribute("userPosts",userPosts);
		
		List<Comment> commentList = commentService.findAllByPostIdInOrderByIdDesc(postIds);
		model.addAttribute("commentList",commentList);
		
		List<Integer> commentUserIds = new ArrayList<Integer>();
		for(Comment c : commentList)
		{
			commentUserIds.add(c.getUserId());
		}
		
		List<User> commentUserList = userService.findAllById(commentUserIds);
		model.addAttribute("commentUserList",commentUserList);
		
		return "userPosts";
	}

	@POST
	@RequestMapping("editProfileDescription")
	public String editProfileDescription(String description) {
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		userService.updateUserDescription(description, user.getUserId());
		return "redirect:/profile";
	}

	@POST
	@RequestMapping("editProfileAvatar")
	public String editProfileAvatar(@RequestPart(name = "fileupload") MultipartFile file) {
		File uploadDirectory = new File("uploads");
		uploadDirectory.mkdirs();

		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);

		String fileName = file.getOriginalFilename();
		String avatarName = user.getName() + user.getUserId() + fileName.substring(fileName.lastIndexOf("."));

		try {
			File oFile = new File("uploads/" + avatarName);
			OutputStream os = new FileOutputStream(oFile);
			InputStream inputStream = file.getInputStream();
			IOUtils.copy(inputStream, os);
			os.close();
			inputStream.close();

			userService.updateUserAvatarUrl(avatarName, user.getUserId());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/profile";
	}
}
