package main.java.com.datamining.service;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.Catagory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Repository
public class CatagoryService {

	@Autowired
	private CommonDAO commondao;
	
	@RequestMapping(method=RequestMethod.POST)
	public void addcat(@ModelAttribute(value="cat") Catagory catagory)
	{
		System.out.println("Catagory"+catagory.getDescription());
		try {
			commondao.create(catagory);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
