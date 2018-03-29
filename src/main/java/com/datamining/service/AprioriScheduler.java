package main.java.com.datamining.service;

import java.util.List;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.model.ProductTransaction;
import main.java.com.datamining.model.Transaction;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



@Service
public class AprioriScheduler {

	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private AprioriService aprioriservice;
	@SuppressWarnings("unchecked")
	//@Scheduled(fixedDelay=360000)
	public void runAprioriAlgorihtem()
	{
		String s[]=null;
		int i=0;
		int maxcount=3;
		List<Transaction> transactionIdLst = commonDAO.getObjectList(new Transaction());
		if(null!=transactionIdLst && transactionIdLst.size()>0)
		{
			s=new String[transactionIdLst.size()];
			for(Transaction t :transactionIdLst)
			{
				Criterion cr =Restrictions.eq("transactionId", t.getId());
				try {
					List<ProductTransaction>productionTransactionList = (List<ProductTransaction>) commonDAO.findByCriteria(new ProductTransaction(), null, cr);
						String temp="";
						for(ProductTransaction pt :productionTransactionList)
						{
							temp=temp+pt.getProductId();
							
						}
					s[i]=temp;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}
			
			aprioriservice.generateItemSet(s,maxcount);
		}
		
	}
}
