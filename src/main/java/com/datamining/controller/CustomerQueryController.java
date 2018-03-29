package main.java.com.datamining.controller;

import main.java.com.datamining.helper.SystemConstants;
import main.java.com.datamining.model.User;
import main.java.com.datamining.service.EmailService;
import main.java.com.datamining.service.Feedback;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerQueryController {

	/*
	 * this method will retrieve info from the contactus page i.e user name, email and send a mail of feedback  
	 */
	@RequestMapping(value="/testajax.html",method=RequestMethod.POST)
	 
	 public String submitCustomerQuery(String name,String email,String message,String phone)
	{
		System.out.println("Name"+name);
		System.out.println("Email "+email);
		//System.out.println("pass: "+password);
			// TODO Auto-generated method stub
			
			String body =SystemConstants.CUST_QUERY_EMAIL_BODY;
			String mailbody =body.replaceAll("FirstName", name).replaceAll("message", message);
			
			String subject = SystemConstants.CUST_QUERY;
		String emailId= "custcareshoppingmania@gmail.com";
			//Feedback.sendEmaill(body, subject, email,password);
			Feedback.sendEmaill(mailbody, subject, emailId);
		System.out.println("sent");
		
		return "contact";
	}
	
	@RequestMapping(value="/customerquery",method=RequestMethod.GET)
	 
	 public String submitCustomerQueryGet(String name,String email,String message,String phone)
	{
		System.out.println("Name"+name);
		System.out.println("Email "+email);
		return "success";
	}

	
}
