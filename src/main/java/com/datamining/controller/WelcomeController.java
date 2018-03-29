package main.java.com.datamining.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.Profile;
import main.java.com.datamining.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@Autowired
	private CommonDAO commmonDAO;

	@RequestMapping(value="/index.html",method=RequestMethod.GET)
	public ModelAndView welcome()
	{
		System.out.println("Inside welcome metohd");
		ModelAndView modelAndView = new ModelAndView("welcome", "stud", new Student());
		return modelAndView;
	}
	
	@RequestMapping(value="/formprocess",method=RequestMethod.POST)
	public String process(@ModelAttribute(value="stud")Student student)
	{
		System.out.println("Name"+student.getFirstName());
		return "blank";
		
	}
	
	@RequestMapping(value="/registration.html",method=RequestMethod.GET)
	public String userRegistration()
	{
		System.out.println("Inside registration metohd");
		
		return "registration";
	}

	
	/*@RequestMapping(value="/userhome.html",method=RequestMethod.GET)
	public String gethome()
	{
		return "userhome";
		
	}*/
	
	@RequestMapping(value="/updateform",method=RequestMethod.GET)
	public ModelAndView process()
	{

		System.out.println("Inside form controller");
		Profile p = new Profile();
		p.setFirstName("Mehul");
		p.setName("Patel");
		List<String> cn = new ArrayList<String>();
		cn.add("United Stated");
		cn.add("China");
		cn.add("Singapore");
		cn.add("Malaysia");
		Map<String,String> country = new HashMap<String,String>();
		country.put("United Stated", "United Stated");
		country.put("China", "China");
		country.put("Singapore", "Singapore");
		country.put("Malaysia", "Malaysia");
		
		ModelAndView view = new ModelAndView("demo");
		Map<String,Object> mymodel = view.getModel();
		mymodel.put("updateDetail", p);
		mymodel.put("list", country);
		mymodel.put("list1", cn);
		return view;
		
	}
}
