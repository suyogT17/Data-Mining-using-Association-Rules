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
public class AprioriProductListService {

	@Autowired
	private CommonDAO commonDAO;
	
	public List<Product> findassociatedProducts(Integer pid)
	{
		List<AprioriRecord> recordset = this.findapriorirecordset(pid);
		List<Integer> setId = this.findsetids(recordset);
		List<AprioriRecord> finalProductIds = commonDAO.fetchApriorirecordset(setId);
		List<Integer> pids = this.findfindproductids(pid,finalProductIds);
		List<Product> products= commonDAO.fetchDashboardProduct(pids);
		return products;
	}

	private List<Integer> findfindproductids(Integer pid, List<AprioriRecord> finalProductIds) {
		// TODO Auto-generated method stub
		Set<Integer> ids = new HashSet<Integer>();
		for(AprioriRecord a : finalProductIds)
		{
			if(pid!=a.getProduct_id())
			{
				ids.add(a.getProduct_id());
			}
			
		}
		List<Integer> pids = new ArrayList<Integer>(ids);
		return pids;
	}

	private List<Integer> findsetids(List<AprioriRecord> recordset) {
		// TODO Auto-generated method stub
		Set<Integer> ids = new HashSet<Integer>();
		for(AprioriRecord a : recordset)
		{
			ids.add(a.getSet_id());
		}
		List<Integer> setIds= new ArrayList<Integer>(ids);
		
		return setIds;
	}

	@SuppressWarnings("unchecked")
	private List<AprioriRecord> findapriorirecordset(Integer pid) {
		// TODO Auto-generated method stub
		List<AprioriRecord> recordset = null;
		Criterion cr = Restrictions.eq("product_id", pid);
		try {
			recordset = (List<AprioriRecord>) commonDAO.findByCriteria(new AprioriRecord(), null, cr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return recordset;
		
	}
}
