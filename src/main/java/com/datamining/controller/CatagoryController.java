package main.java.com.datamining.controller;

import main.java.com.datamining.model.Catagory;
import main.java.com.datamining.service.CatagoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CatagoryController {
	@Autowired
	private CatagoryService catagoryservice;
	
	/*
	 * this method will load the add category page
	 */
@RequestMapping(value="/catagory.html",method=RequestMethod.GET)
public ModelAndView catagory(@ModelAttribute(value="cat") Catagory catagory)
{
	ModelAndView modelAndView=new ModelAndView("catagory", "cat", new Catagory());
	return modelAndView;
}

/*
 * this method reload the add category page to enter more categories after clicking on the submit button  
 */
@RequestMapping(value="/addcatagory.html",method=RequestMethod.POST)
public ModelAndView addcatagory(@ModelAttribute(value="cat") Catagory catagory)
{	
	
	catagoryservice.addcat(catagory);
	ModelAndView modelAndView=new ModelAndView("catagory", "cat", new Catagory());
	return modelAndView;
}
}


