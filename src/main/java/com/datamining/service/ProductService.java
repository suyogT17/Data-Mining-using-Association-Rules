package main.java.com.datamining.service;

import java.util.List;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.Catagory;
import main.java.com.datamining.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	@Autowired
	private CommonDAO commonDAO;
	
	public void addProduct(Product p)
	{
		Catagory c = new Catagory();
		c.setCid(Integer.parseInt(p.getCategoryId()));
		p.setCatagory(c);
		
		try {
			commonDAO.create(p);
		} catch (Exception e) {
			System.out.println("Add product failed");
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Catagory> getCatagoryList()
	{
		List<Catagory> catagoryList = commonDAO.getObjectList(new Catagory());
		return catagoryList;
	}
}
