package main.java.com.datamining.controller;

import java.util.List;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.helper.Helper;
import main.java.com.datamining.model.CartList;
import main.java.com.datamining.model.UserCartdto;
import main.java.com.datamining.service.CartService;
import main.java.com.datamining.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderSummaryController extends AbstractController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	CommonDAO commonDAO;
	
	/*
	 * this method displays an order summary details. 
	 */
	@RequestMapping(value="/ordersummary.html",method=RequestMethod.GET)
	public ModelAndView getOrderDetails()
	{
		String username=Helper.getUsername();
		//commonDAO.executedeletequery(userame);
		List<UserCartdto> orderList = cartService.getorderDetailsList();
		System.out.println("list size"+orderList.size());
		CartList list = new CartList();
		
		if(null!=orderList)
		{
			System.out.println("Setting Array List");
			list.setCartProductList(orderList);
		}
		
		
		return new ModelAndView("ordersummary" , "orderList", list);
	}
	
	@RequestMapping(value="/next1.html",method=RequestMethod.POST)
	public ModelAndView processTransaction(@ModelAttribute("orderList") CartList list)
	{
		List<UserCartdto> ud = list.getCartProductList();
		System.out.println("size of product"+ud.size());
		int total = 0;
		for(UserCartdto d : ud)
		{
			if(null!=d && null!=d.getPrice())
			{
				total=total+(d.getPrice()*d.getQuantity());
				
			}
			else
			{
				ud.remove(d);
			}
		}
		list.setTotalprice(total);
		list.setCartProductList(ud);
	
		return new ModelAndView("billsummary" , "orderList", list);
	}
	
	@RequestMapping(value="/next2.html",params="next2", method=RequestMethod.POST)
	public ModelAndView processbill(@ModelAttribute("orderList") CartList list)
	{
		List<UserCartdto> ud = list.getCartProductList();
		int total = list.getTotalprice();
		Integer id = transactionService.createTransaction(ud, total);
		
		//Integer id =25;
		System.out.println("tmy ransaction id="+id);
		

		return new ModelAndView("confirmOrder","transactionId",id);
	}
	
	@RequestMapping(value="/next2.html",params="previous1", method=RequestMethod.POST)
	public ModelAndView gotooverallsummary(@ModelAttribute("orderList") CartList list)
	{
		List<UserCartdto> ud = list.getCartProductList();
		int total = 0;
		for(UserCartdto d : ud)
		{
			System.out.println("product name"+d.getProductName());
			System.out.println("product price"+d.getPrice());
			System.out.println("product quan"+d.getQuantity());
			
		}
		list.setTotalprice(total);
		
		return new ModelAndView("ordersummary" , "orderList", list);
	}
}


