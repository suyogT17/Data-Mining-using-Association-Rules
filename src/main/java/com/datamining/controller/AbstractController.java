package main.java.com.datamining.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.com.datamining.model.Usercart;
import main.java.com.datamining.service.CartService;
@Controller
public abstract class AbstractController {

	@Autowired
	private CartService cartservice;
	@ModelAttribute("list")
	public List<Usercart> getAllCartProduct()
	{
		List<Usercart> usercartList = cartservice.getUserCart(); 
		return usercartList;
	}
	
/*	@RequestMapping(value="/example.html",method=RequestMethod.GET)
	public String example()
	{
		return "example";
	}
*/}
