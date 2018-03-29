package main.java.com.datamining.controller;

import main.java.com.datamining.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PasswordManagementController extends AbstractController {

	@Autowired
	private UserService userservice;
	/*
	 * this method displays an change password page
	 */
	@RequestMapping(value="/changepassword.html",method=RequestMethod.GET)
	public String changePassword()
	{
		return "changepassword";
	}
	
	
	/*
	 * this method updates the password
	 */
	@RequestMapping(value="/updatepassword",method=RequestMethod.POST)
	@ResponseBody
	public String updatePassword(String password)
	{
		System.out.println("Password "+password);
		String status = userservice.updatepassword(password);
		return status;
	}

	
	
}