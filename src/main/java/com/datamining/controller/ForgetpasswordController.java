package main.java.com.datamining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ForgetpasswordController {
	@RequestMapping(value="/forgetpassword.html",method=RequestMethod.GET)
	public String forgetPasswordpage()
	{
		return "forgetpassword";
	}
}
