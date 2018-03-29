package main.java.com.datamining.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.AprioriRecord;
import main.java.com.datamining.model.Product;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoadDashboardProductService {

	@Autowired
	private CommonDAO commonDAO;
	@SuppressWarnings("unchecked")
	public List<Product> getsmartProduct() {
		// TODO Auto-generated method stub
		Criterion cr = Restrictions.eq("minSupport", 3);
		List<Product>productList =null;
		try {
			List<AprioriRecord> recordList = (List<AprioriRecord>) commonDAO.findByCriteria(new AprioriRecord(), null, cr);
			
			if(null== recordList || recordList.size()==0)
			{
				List<Product> products= commonDAO.getObjectList(new Product());
				return products;
			}
			List<Integer> productIdList = retrivedProjectId(recordList);
			productList =commonDAO.fetchDashboardProduct(productIdList);
			if(null == productList || productIdList.size()<4)
			{
				List<Product> newproductList = commonDAO.getObjectList(new Product());
				if(null!=productIdList)
				{
					Set<Product> p = new HashSet<Product>();
					p.addAll(productList);
					p.addAll(newproductList);
					newproductList = new ArrayList<Product>(p);
					
				}
				return newproductList;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	private List<Integer> retrivedProjectId(List<AprioriRecord> recordList) {
		// TODO Auto-generated method stub
		Set<Integer> ids = new HashSet<Integer>();
		for(AprioriRecord a :recordList)
		{
			ids.add(a.getProduct_id());
		}
		List<Integer> list = new ArrayList<Integer>(ids);
		return list;
	}

}
