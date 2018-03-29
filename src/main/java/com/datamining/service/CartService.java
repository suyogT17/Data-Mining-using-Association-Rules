package main.java.com.datamining.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.helper.Helper;
import main.java.com.datamining.model.Product;
import main.java.com.datamining.model.User;
import main.java.com.datamining.model.UserCartdto;
import main.java.com.datamining.model.Usercart;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	public Product getProduct(Integer id)
	{
		Product product = new Product();
		Criterion criterion = Restrictions.eq("id", id);
		
		try {
			product = (Product) commonDAO.findByCriteriaUniqueResultWithCritera(product, null, criterion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<UserCartdto> getorderDetailsList() {
		// TODO Auto-generated method stub
		
		String userName =Helper.getUsername();
		
		Criterion criterion = Restrictions.eq("username",userName);
		Usercart cart = new Usercart();
		List<Usercart> usercartList  = null;
		try {
			usercartList=(List<Usercart>) commonDAO.findByCriteria(cart, null, criterion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//code for fetching List of UserCart
		//remove following hardcoding
		
		
		List<UserCartdto> usercartdtoList = getUserCartdto(usercartList);
		//return null;
		commonDAO.executedeletequery(userName);
		return usercartdtoList;
	}

	private List<UserCartdto> getUserCartdto(List<Usercart> usercartList) {
		// TODO Auto-generated method stub
		List<UserCartdto> usercartdto = new ArrayList<UserCartdto>();
		for(Usercart u : usercartList)
		{
			UserCartdto user = new UserCartdto();
			user.setProductId(u.getProductId());
			System.out.println("indto getting value:"+u.getProductId());
			
			user.setProductName(u.getProductName());
			user.setQuantity(1);
			user.setPrice(u.getPrice());
			user.setUsername(u.getUsername());
			usercartdto.add(user);
		}
		
		return usercartdto;
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
		String userName = Helper.getUsername();
		Usercart usercart  = new Usercart();
		usercart.setPrice(product.getPrice());
		usercart.setProductId(product.getId());
		usercart.setProductName(product.getName());
		usercart.setUsername(userName);
		try {
			commonDAO.create(usercart);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usercart> getUserCart()
	{
		String userName = Helper.getUsername();
		Criterion criterion = Restrictions.eq("username",userName);
		Usercart cart = new Usercart();
		List<Usercart> usercartList  = null;
		try {
			usercartList=(List<Usercart>) commonDAO.findByCriteria(cart, null, criterion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usercartList;
	}
	
	
		
}
