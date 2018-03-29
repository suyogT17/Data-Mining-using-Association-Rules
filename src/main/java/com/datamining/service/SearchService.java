package main.java.com.datamining.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.Product;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchService {

	@Autowired
	private CommonDAO commonDAO;
	
	
	public List<Product> searchProducts(String searchText)
	{
		String words[]=searchText.trim().split(" ");
		Set<Product> productSet= new HashSet<Product>();
		if(null!=words && words.length>0)
		{
			for(String text:words)
			{
				List<Product> productList =commonDAO.getSearchedProduct(text);
				productSet.addAll(productList);

			}
		}
		 List<Product> newproductList = new ArrayList<Product>(productSet);
		 return newproductList;
	}
}
