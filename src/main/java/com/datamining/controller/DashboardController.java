package main.java.com.datamining.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.helper.SystemConstants;
import main.java.com.datamining.model.Product;
import main.java.com.datamining.model.User;
import main.java.com.datamining.model.Usercart;
import main.java.com.datamining.service.AprioriScheduler;
import main.java.com.datamining.service.CartService;
import main.java.com.datamining.service.LoadDashboardProductService;
import main.java.com.datamining.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class DashboardController extends AbstractController {
	
	@Autowired
	private LoadDashboardProductService loadDashboardProductService;
	
	@Autowired
	private CommonDAO commondao;
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	AprioriScheduler apriorischedular;
	
	/*
	 * this method will load the homepage of an user
	 */
	
	@RequestMapping(value = "/home.html",method = RequestMethod.GET)
    public String getHomePage(Model model){
		/* apriorischedular.runAprioriAlgorihtem();*/
	     
	    
		
        List<Usercart> usercartList = new ArrayList<Usercart>();
        List<Product> productList = loadDashboardProductService.getsmartProduct();
        usercartList=cartservice.getUserCart();
        //model.addAttribute("list", usercartList);
        model.addAttribute("productList", productList);
       
		System.out.println("algorith runs");
       return "userhome";
       
       
 
    }
	
	/*
	 * this page load the home page for user if User get login
	 * and shows admin dashboard id admin login
	 */
	@RequestMapping(value="/dashboard.html",method=RequestMethod.GET)
	public ModelAndView authenticationHandler()
	{
	
		System.out.println("Inside dashboar controller");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
    	apriorischedular.runAprioriAlgorihtem();
        if(role.contains(SystemConstants.USER_ROLE))
        {
        	ModelAndView view = new ModelAndView(new RedirectView("home.html",
    				true));
    		return view;
        }
        else
        {
        	
        	ModelAndView view = new ModelAndView(new RedirectView("viewalltransactions.html",
    				true));
    		return view;
        }
		
	}
  
}
