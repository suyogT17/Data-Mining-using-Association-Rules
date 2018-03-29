package main.java.com.datamining.controller;

import main.java.com.datamining.dto.UserRegistrationDTO;
import main.java.com.datamining.service.RegistrationService;
import main.java.com.datamining.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class RegistrationController  {
	
	@Autowired
	private RegistrationService registrationService;
	
	
	/*
	 * this method displays User registration page 
	 */
	@RequestMapping(value="/userregistration.html",method=RequestMethod.GET)
	public ModelAndView getUserRegistration()
	{
		
		return new ModelAndView("userregistration","userregistratindto",new UserRegistrationDTO());
	}
	
	/*
	 * this method stores the registration data in the database
	 */
	@RequestMapping(value="/processregistrant.html",method=RequestMethod.POST)
	public ModelAndView processRegistrationRequest(@ModelAttribute("userregistratindto") UserRegistrationDTO userregdto)
	
	{
		
		registrationService.insertregistrant(userregdto);
		return new ModelAndView("login");
	}
	
	/*
	 * this method generates an verification code and send it to the user.
	 */
	@RequestMapping(value="/generateverificationcode.do",method=RequestMethod.POST)
	@ResponseBody public String generatecode(String username,String emailId)
	{
		System.out.println("username "+username);
		System.out.println("email id"+emailId);
		try {
			registrationService.generateverificationcode(username,emailId);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
	}
	
	/*
	 * this method verify the verification code entered by the user is correct or not
	 */
	
	@RequestMapping(value="/verfycode.do",method=RequestMethod.POST)
	@ResponseBody public String codeverification(String username,String code)
	{
		System.out.println("username "+username);
		System.out.println("code"+code);
		String status= registrationService.verifyuser(username,code);
		return status;
	}
}
