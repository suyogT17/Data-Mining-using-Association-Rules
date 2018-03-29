package main.java.com.datamining.controller;

import java.util.List;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.Product;
import main.java.com.datamining.service.AprioriProductListService;
import main.java.com.datamining.service.AprioriScheduler;
import main.java.com.datamining.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductDisplayController extends AbstractController {
	
	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private CartService  cartService;
	
	@Autowired
	private AprioriScheduler service;
	
	@Autowired
	private AprioriProductListService aprioriProductListService;
	
	/*
	 * this method displays about product page where user can see the product details and the related products
	 */
	@RequestMapping(value="/aboutproduct.html",method=RequestMethod.GET)
	public String getProductDetails(@RequestParam  ("id") String id,Model model)
	{
		int pid = Integer.parseInt(id);
		Product product = cartService.getProduct(pid);
		List<Product> productlist = aprioriProductListService.findassociatedProducts(pid);
		if(productlist!=null)
		{
			model.addAttribute("product", product);
		model.addAttribute("productlist", productlist);
		}
		else
		{

			model.addAttribute("product", product);
		}
		return "aboutproduct";
	}
	
	@RequestMapping(value="/timepass.html",method=RequestMethod.GET)
	public String timepass()
	{
		
		
		service.runAprioriAlgorihtem();
		return "xyz";
	}
	

}
