package main.java.com.datamining.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.com.datamining.model.Product;
import main.java.com.datamining.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductSearchController extends AbstractController {

	@Autowired
	private SearchService searchservice;
	
	/* 
	 * this method display the search result after searching an product
	 */
	@RequestMapping(value="/searchProduct.html",method=RequestMethod.POST)
	public String fetchProducts(Model model,@RequestParam(value="searchtext") String searchText)
	{
		System.out.println("search text"+searchText);
		String searchletters =searchText.trim();
		List<Product> productList = searchservice.searchProducts(searchletters);
		
		System.out.println(productList.size());
		
		/*Product p1 = new Product();
        p1.setDescription("Smart Mobile phone");
        p1.setName("SAMSUNG GALAXY J");
        p1.setId(1);
        
        Product p2 = new Product();
        p2.setDescription("LG SMART Refrigerator");
        p2.setName("LG NO 1");
        p2.setId(2);
        
        Product p3 = new Product();
        p3.setDescription("LENOVO HIGH TECH LAPTOP");
        p3.setName("Lenovo Ultra Slim");
        p3.setId(3);
        
        Product p4 = new Product();
        p4.setDescription("PUMA Sports Shoe");
        p4.setName("PUMA Sports for Ever");
        p4.setId(4);
        
        Product p5 = new Product();
        p5.setDescription("Manyavar Sherwani");
        p5.setName("Manyavar Shadi no1");
        p5.setId(5);
        
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        */
		
        List<String> catagorylist= new ArrayList<String>();
        catagorylist.add("ELECTRONIC");
        catagorylist.add("CLOTHES");
        catagorylist.add("SHOES");
        model.addAttribute("productList", productList);
        model.addAttribute("menulist", catagorylist);
        
        return "searchresults";
	}
	
	
}
