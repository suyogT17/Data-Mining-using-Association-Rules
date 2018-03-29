package main.java.com.datamining.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.datamining.service.AprioriScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@Autowired
	AprioriScheduler aprioriScheduler;
	/*
	 * this method displays login page  
	 */
	@RequestMapping(value="/login.html",method=RequestMethod.GET)
	public String loginpage()
	{
		//aprioriScheduler.runAprioriAlgorihtem();
		return "login";
	}
	
	/*
	 * this method is for logout. 
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null)
		{
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}
		return "redirect:/login.html?logout";
		
	}
}
