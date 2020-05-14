package com.wlochynski.fashiongram.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;



@Controller
public class ProfilePageController {

	@Autowired
	UserService userService;
	
	@GET
	@RequestMapping("profile")
	public String showProfilePage(Model model)
	{
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		model.addAttribute("user",user);
		return "profile";
	}
	
	@POST
	@RequestMapping("editProfileDescription")
	public String editProfileDescription(String description)
	{
		String userEmail = UserUtilites.getLoggedUser();
		User user = userService.findUserByEmail(userEmail);
		userService.updateUserDescription(description, user.getUserId());
		return "redirect:/profile";
	}
	
	@POST
	@RequestMapping("editProfileAvatar")
	public String editProfileAvatar(@RequestPart(name = "fileupload") MultipartFile file)
	{
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
