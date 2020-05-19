package com.wlochynski.fashiongram.controllers;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.FollowService;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class MainPageController {

	@Autowired
	FollowService followService;

	@Autowired
	UserService userService;

	@GET
	@RequestMapping(value = { "/", "/index" })
	public String mainPage(Model model) {
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);

		model.addAttribute("user", user);
		if (followService.countFollowsByFollowerId(user.getUserId()) == 0) {
			List<Integer> topUsersIdByFollowers = followService.getTopUsersIdByFollowers();
			List<User> topUsersByFollowers = userService.findAllById(topUsersIdByFollowers);
			model.addAttribute("topUsersByFollowers", topUsersByFollowers);
		}

		return "index";
	}

}
