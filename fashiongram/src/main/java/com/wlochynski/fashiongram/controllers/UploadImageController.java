package com.wlochynski.fashiongram.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.wlochynski.fashiongram.models.Post;
import com.wlochynski.fashiongram.models.User;
import com.wlochynski.fashiongram.services.PostService;
import com.wlochynski.fashiongram.services.UserService;
import com.wlochynski.fashiongram.utilites.UserUtilites;

@Controller
public class UploadImageController implements HandlerExceptionResolver {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;

    @POST
    @RequestMapping("/upload")
    public RedirectView handleFile(@RequestPart(name = "fileupload") MultipartFile file, RedirectAttributes redir, Post uploadedPost) {
        File uploadDirectory = new File("uploads");
        uploadDirectory.mkdirs();
        RedirectView redirectView;
        
    	//create a new, unique name of image
        String fileName = file.getOriginalFilename();
        int imageNumber;
        if(postService.findFirstByOrderByIdDesc() != null)
        {
        	imageNumber = postService.findFirstByOrderByIdDesc().getId() + 1;
        }
        else 
        {
        	imageNumber = 1;
        }
        

        String newUniqName = imageNumber + fileName.substring(fileName.lastIndexOf("."));
        
        try {
        	//save image
            File oFile = new File("uploads/" + newUniqName);
            OutputStream os = new FileOutputStream(oFile);
            InputStream inputStream = file.getInputStream();
            IOUtils.copy(inputStream, os);
            os.close();
            inputStream.close();
            
            //get user
    		String userEmail = UserUtilites.getLoggedUser();
    		User user = userService.findUserByEmail(userEmail);
    		
    		//set post details and save to db
    		uploadedPost.setUserId(user.getUserId());
            uploadedPost.setPhotoName(newUniqName);
            postService.savePost(uploadedPost);
            
            //create successful view 
            redirectView = new RedirectView("/index",true);
            //redir.addFlashAttribute("twojpost", null); //added post should be first on main page
            
        } catch (IOException e) {
            e.printStackTrace();
            
            //create view with error
            redirectView = new RedirectView("/addPost",true);
            String error = messageSource.getMessage("error.fileNotUploaded", null, LocaleContextHolder.getLocale()) + e.getMessage();
            redir.addFlashAttribute("error",error);
        }
        return redirectView;
    }
    
    //exception for file size exceeds limit
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		    ModelAndView modelAndView = new ModelAndView("addPost");
		    if (ex instanceof MaxUploadSizeExceededException) {
		        modelAndView.getModel().put("error", messageSource.getMessage("error.fileSizeExceedsLimit", null, LocaleContextHolder.getLocale()));
		    }
		    return modelAndView;
	}
}