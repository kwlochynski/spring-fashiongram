package com.wlochynski.fashiongram.controllers;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.models.Follow;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.FollowService;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class FollowController {

	@Autowired
	FollowService followService;

	@Autowired
	UserService userService;

	@GET
	@RequestMapping("/follow/{profileId}")
	public String followUser(@PathVariable("profileId") int profileId) {
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);

		if (profileId != user.getUserId()) {
			if (followService.countFollowsByUserIdAndFollowerId(profileId, user.getUserId()) == 0) {
				// set values of follow and save to db
				Follow follow = new Follow();
				follow.setFollowerId(user.getUserId());
				follow.setUserId(profileId);
				followService.saveFollow(follow);
			} else {
				followService.deleteFollowByUserIdAndFollowerId(profileId, user.getUserId());
			}
		}

		return "redirect:/profile/" + profileId;
	}
}
