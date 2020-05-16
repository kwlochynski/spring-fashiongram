package com.wlochynski.fashiongram.controllers;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.models.Comment;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.CommentService;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class AddCommentController {

	@Autowired
	UserService userService;

	@Autowired
	CommentService commentService;

	@POST
	@RequestMapping("addComment/{postId}")
	public String addComment(@PathVariable int postId, String commentContent) {
		// get user
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);

		// create comment and set values
		Comment comment = new Comment();
		comment.setContent(commentContent);
		comment.setPostId(postId);
		comment.setUserId(user.getUserId());

		// save comment to db
		commentService.saveComment(comment);

		return "redirect:/discover";
	}

}
