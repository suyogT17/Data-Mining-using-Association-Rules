package main.java.com.datamining.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.datamining.helper.SystemConstants;
import main.java.com.datamining.model.Catagory;
import main.java.com.datamining.model.Product;
import main.java.com.datamining.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProductController extends AbstractController{
	
	@Autowired
	private ProductService productService;

	/*
	 * this method loads the add product page 
	 */
	@RequestMapping(value="/addproduct.html",method=RequestMethod.GET)
	public ModelAndView addproduct()
	{
		
		List<Catagory> clist = productService.getCatagoryList();
		ModelAndView view = new ModelAndView("addproduct","product",new Product());
		view.addObject("catagorylist",clist);
		return view;
	}
	
	/*
	 * this method reloads the add product page to add more product
	 */
	@RequestMapping(value="/addproduct1.html",method=RequestMethod.POST)
	public ModelAndView processProduct(@ModelAttribute(value="product") Product p,
			@RequestParam("imagefile") MultipartFile file)
	{
		String filename = file.getOriginalFilename();
		
		p.setProductImage(filename);
		String contextpath = SystemConstants.IMAGE_PATH;
		 try {
			file.transferTo(new File(contextpath+file.getOriginalFilename()));
			productService.addProduct(p);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	//productService.addProduct(p);
		
		List<Catagory> clist = productService.getCatagoryList();
		ModelAndView view = new ModelAndView("addproduct","product",new Product());
		view.addObject("catagorylist",clist);
		return view;
	}
	
}
