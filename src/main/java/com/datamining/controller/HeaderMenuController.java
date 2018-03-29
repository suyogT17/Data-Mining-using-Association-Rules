package main.java.com.datamining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeaderMenuController extends AbstractController {

	/*
	 * this method load the contactus page on which user can contact to us with our email
	 */
	@RequestMapping(value="/contactus.html",method=RequestMethod.GET)
	public String contact()
	{
		return "contact";
	}
	
	/*
	 * this method displays the service page of our web application where all services are listed
	 */
	@RequestMapping(value="/service.html",method=RequestMethod.GET)
	public String services()
	{
		return "services";
	}
	
	/*
	 * this method displays FAQ page
	 */
	@RequestMapping(value="/faq.html",method=RequestMethod.GET)
	public String faqs()
	{
		return "faq";
	}

	/* 
	 * this page displays the about us page 
	 */
	@RequestMapping(value="/about.html",method=RequestMethod.GET)
	public String about()
	{
		return "about";
	}

	
}
