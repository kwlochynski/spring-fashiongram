package com.wlochynski.fashiongram.controllers;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.dto.TopUserDTO;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.FollowService;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class TopPageController {
	
	@Autowired
	FollowService followService;

	@Autowired
	UserService userService;

	@GET
	@RequestMapping("/top")
	public String getTopPage(Model model)
	{
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user", user);
		
		List<TopUserDTO> topUsersByFollowers = userService.getTopUserDTO(PageRequest.of(0, 20));
		model.addAttribute("topUsersByFollowers", topUsersByFollowers);
		
		return null;
	}
	
}
