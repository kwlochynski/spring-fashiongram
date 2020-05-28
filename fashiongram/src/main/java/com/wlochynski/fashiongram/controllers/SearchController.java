package com.wlochynski.fashiongram.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wlochynski.fashiongram.dto.TopUserDTO;
import com.wlochynski.fashiongram.services.UserService;

@Controller
public class SearchController {

	@Autowired
	UserService userService;

	@RequestMapping("search")
	public void getSearchResult(HttpServletRequest req, HttpServletResponse res, String param)
			throws IOException {
		res.addHeader("Content-Type", "text/html; charset=utf-8");
		PrintWriter pw = res.getWriter();
		String result = "";

		String newParam = param + "%";
		List<TopUserDTO> topUsersBySearch = userService.getTopUserBySearchParam(newParam, PageRequest.of(0, 5));
		for (TopUserDTO tu : topUsersBySearch) {
			result += "						<div id=\"searchResult\" class=\"searchResult\">\r\n"
					+ "							<img  style=\"cursor:pointer \" onclick=\"window.location.href='/profile/"+ tu.getUserId() +"';\"  class=\"searchAvatar\" src=\"/uploads/"
					+ tu.getAvatarUrl() + "\">\r\n"
					+ "							<span style=\"cursor:pointer \" onclick=\"window.location.href='/profile/"
					+ tu.getUserId() + "';\" class=\"searchName\">" + tu.getName() + " </span>\r\n"
					+ "						</div>";
		}
		pw.write(result);
	}

}
