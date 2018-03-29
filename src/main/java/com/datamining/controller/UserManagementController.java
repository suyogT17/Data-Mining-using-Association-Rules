package main.java.com.datamining.controller;

import java.util.List;

import main.java.com.datamining.dto.UserRegistrationDTO;
import main.java.com.datamining.helper.Helper;
import main.java.com.datamining.model.Address;
import main.java.com.datamining.model.User;
import main.java.com.datamining.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManagementController {

	@Autowired
	private UserService userservice;
	
	@Autowired
	UserRegistrationDTO userregistrationdto;
	
	/* 
	 * this method displays all the users.
	 */
	@RequestMapping(value = "/viewallusers.html", method = RequestMethod.GET)
	public ModelAndView showAllUsers() {

		final ModelAndView view = new ModelAndView("viewallusers");
				return view;
	}
	
	@RequestMapping(value = "/viewalluser.html", method = RequestMethod.GET)
	@ResponseBody
	public String performSearchUser() {
		List<User> users= userservice.getAllActiveUsers();
		String json = userservice.getJsonString(users);
		return json;
			
	}
	
	/*
	 * this method is used to update the user details
	 */
	@RequestMapping(value="/updateuser.html",method=RequestMethod.GET)
	public ModelAndView updateuserprofile()
	{
		String username=Helper.getUsername();
	System.out.println("in update");
		User user = userservice.fetchUser(username);
		return new ModelAndView("updateuser","user",user);
		
	}
	//@RequestParam("username")String username
	
	/*
	 * this method disables the user.
	 */
	@RequestMapping(value="/userDeprovisionrequest.html",method=RequestMethod.GET)
	public ModelAndView deleteuserprofile(@RequestParam("userName")String username)
	{
	System.out.println("in delete");
		User user = userservice.fetchUser(username);
		userservice.deleteuser(user);
		return new ModelAndView("viewallusers");
		
	}
	
	
	
	
	
	
	
	/*@RequestMapping(value="/userDeprovisionrequests.html",method=RequestMethod.POST)
	public ModelAndView deleteusers(@ModelAttribute(value="user") User user)
	{
		userservice.deleteuser(user);
		final ModelAndView view = new ModelAndView("viewallusers");
		return view;

	}
	
	*/
	
	@RequestMapping(value="/updateusers.html",method=RequestMethod.POST)
	public ModelAndView updateusers(@ModelAttribute(value="user") User user)
	{
		userservice.updateuser(user);
		final ModelAndView view = new ModelAndView("updateuser");
		return view;

	}
	
	/*
	 * this method displays the user profile page
	 */
	
	@RequestMapping(value="/userprofile.html",method=RequestMethod.GET)
	public String visitUserProfile(Model model)
	{
		
		  userregistrationdto = userservice.getregistrationDetails();
		 model.addAttribute("userprofile", userregistrationdto);
		return "userprofiles";
	}
	
	
	
}
