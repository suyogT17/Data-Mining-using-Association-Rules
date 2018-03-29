package main.java.com.datamining.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.java.com.datamining.helper.SystemConstants;
import main.java.com.datamining.service.AprioriService;
import main.java.com.datamining.service.EmailService;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*@SuppressWarnings("deprecation")
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//Session session = sf.openSession();
		String line ="smart phones";
		String words[]=line.split(" ");
		System.out.println("lengthh "+words.length);
		Set<Product> productSet= new HashSet<Product>();
		if(null!=words && words.length>0)
		{
			for(String text:words)
			{
				 List<Product> productList =null;
				Session session = sf.openSession();
				Criterion productName =Restrictions.ilike("name",text,MatchMode.ANYWHERE);
				Criterion description = Restrictions.ilike("description",text,MatchMode.ANYWHERE);
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(productName);
				disjunction.add(description);
				final Criteria crit = session.createCriteria(Product.class);

			    try {
			    	
			     crit.add(disjunction);
			     productList= crit.list();
			     productSet.addAll(productList);
			     System.out.println("search for words "+text);
			     for(Product p :productList)
			     {
			    	 System.out.println(p.getName());
			    	 
			     }
			     
			    } catch (final Exception e) {
			      System.out.println("find by criteria unique result with criteria failed");
			      e.printStackTrace();
			    }
			    finally{
			    	session.close();
			    }
			  

			   
			   
			}
		}
		
		 List<Product> newproductList = new ArrayList<>(productSet);
		   System.out.println("###################");
		   for(Product p :newproductList)
		     {
		    	 System.out.println(p.getName());
		    	 
		     }*/
		
		/*List<Integer> productidList = new ArrayList<Integer>();
		productidList.add(1);
		productidList.add(2);
		productidList.add(3);
		Transaction sessionTransaction = session.getTransaction();
		  List<Product> productList= null;
		  if (!sessionTransaction.isActive()) {
		      session.beginTransaction();
		    }
		  try{
			  
			  Query query = session.createQuery("from Product p where p.id in (:ids)");
			  query.setParameterList("ids", productidList);
			   productList = (query.list());
			   System.out.println(productidList.size());
			   System.out.println("done");
		  }catch(Exception e)
		  {
			  sessionTransaction.rollback();
		      System.out.println("CommonDAO fetchDashboardProduct failed");
		      e.printStackTrace();
		  }
		  finally{
			  session.close();
		  }*/
		
		String body =SystemConstants.VERIFICATION_CODE_EMAIL_BODY;
		String mailBody=body.replaceAll("FirstName", "Suyog").replaceAll("userid", "suyog").replaceAll("autoGenCode", "7996");
		
		String subject = SystemConstants.VERIFICATION_CODE_EMAIL_SUBJECT;
		String email ="";
		EmailService.sendEmaill(mailBody, subject,email);
		
	}

}  
