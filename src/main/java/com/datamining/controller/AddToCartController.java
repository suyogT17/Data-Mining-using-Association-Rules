package main.java.com.datamining.controller;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.Product;
import main.java.com.datamining.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AddToCartController {
	
	@Autowired
	private CartService cartService;
	/* @auther
	 * This method is used to add the product to cart. 
	 * by clicking on the cart Icon. 
	 */
	@RequestMapping(value="/addproducttocart.html",method=RequestMethod.POST)
	@ResponseBody public String addToCart(String productId)
	{
		
		Integer prodId= Integer.parseInt(productId);
		System.out.println("Prod it "+prodId);
		Product product = cartService.getProduct(prodId);
		cartService.addProduct(product);
		return product.getName();
		//return "LG";
		
	}
	

}