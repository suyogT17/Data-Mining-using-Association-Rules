package main.java.com.datamining.dao;

import java.util.List;

import main.java.com.datamining.model.AprioriRecord;
import main.java.com.datamining.model.Product;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class CommonDAO extends AbstractDAO {

	 public Integer create(final Object command) throws Exception
	  {
		  	final Session session = this.getSessionFactory().openSession();
			Transaction sessionTransaction = session.getTransaction();
			Integer id =null;
		  try {
			  sessionTransaction.begin();
			  id=(Integer) session.save(command);
	    	sessionTransaction.commit();
	    	session.close();
	    } catch (Exception e) {
	    	System.out.println("CommonDAO create failed");
	    	sessionTransaction.rollback();
	    	session.close();
	        e.printStackTrace();
	    }
		  return id;

	  }
	 
	 public Object findByCriteriaUniqueResultWithCritera(final Object object,
		      final Order order, final Criterion... criterions) throws Exception
		  {

		 	final Session session = this.getSessionFactory().openSession();
		 	final Criteria crit = session.createCriteria(object.getClass());

		    try {
		    	
		      for(final Criterion c : criterions) {
		        crit.add(c);
		      }
		      crit.setMaxResults(1);
		      crit.setFirstResult(0);
		      if (order != null) {
		        crit.addOrder(order);
		      }
		      final Object retObj = crit.uniqueResult();

		      return retObj;
		    } catch (final Exception e) {
		      System.out.println("find by criteria unique result with criteria failed");
		      e.printStackTrace();
		    }
		    finally{
		    	session.close();
		    }

		    return null;

		  }
	 
	 public Object findByCriteria(final Object object,
		      final Order order, final Criterion... criterions) throws Exception
		  {

		 	final Session session = this.getSessionFactory().openSession();
		 	final Criteria crit = session.createCriteria(object.getClass());

		    try {
		    	
		      for(final Criterion c : criterions) {
		        crit.add(c);
		      }
		      
		      if (order != null) {
		        crit.addOrder(order);
		      }
		      final Object retObj = crit.list();

		      return retObj;
		    } catch (final Exception e) {
		      System.out.println("find by criteria unique result with criteria failed");
		      e.printStackTrace();
		    }
		    finally{
		    	session.close();
		    }

		    return null;

		  }
	 
	 public void delete(final Object entityObj)
	  {
		 final Session session = this.getSessionFactory().openSession();
		 Transaction sessionTransaction = session.getTransaction();
		    if (!sessionTransaction.isActive()) {
		      session.beginTransaction();
		    }
		    try {
		    	session.delete(entityObj);
		    	sessionTransaction.commit();
		    } catch (Exception e) {
		      System.out.println("CommonDAO Delete failed");
		      sessionTransaction.rollback();
		      e.printStackTrace();
		    }
		    finally{
		    	session.close();
		    }
		 
	  }
	  
	  public void merge(final Object command) throws Exception
	  {
		  final Session session = this.getSessionFactory().openSession();  
		Transaction sessionTransaction = session.getTransaction();
	    if (!sessionTransaction.isActive()) {
	      session.beginTransaction();
	    }
	    try {
	      session.merge(command);
	      sessionTransaction.commit();
	    } catch (Exception e) {
	      System.out.println("CommonDAO merge failed");
	      sessionTransaction.rollback();
	      e.printStackTrace();
	    }
	    finally{
	    	session.close();
	    }
	  }
	  
	  public void saveOrUpdate(final Object command) throws Exception
	  {

		  final Session session = this.getSessionFactory().openSession();
		 Transaction sessionTransaction = session.getTransaction();
		 if (!sessionTransaction.isActive()) {
	      session.beginTransaction();
	    }

	    try {
	      session.saveOrUpdate(command);
	      sessionTransaction.commit();
	    } catch (Exception e) {
	    	sessionTransaction.rollback();
	      System.out.println("CommonDAO saveOrUpdate failed");
	      e.printStackTrace();
	    }
	    finally{
	    	session.close();
	    }
	  }
	  
	  public List getObjectList(final Object object) 
		{

		  final Session session = this.getSessionFactory().openSession();
			 Transaction sessionTransaction = session.getTransaction();
			 if (!sessionTransaction.isActive()) {
		      session.beginTransaction();
		    }
				List list = null;
		    try {
		    	final Criteria crit = session.createCriteria(object.getClass());
				list = crit.list();
		      sessionTransaction.commit();
		    } catch (Exception e) {
		    	sessionTransaction.rollback();
		      System.out.println("CommonDAO saveOrUpdate failed");
		      e.printStackTrace();
		    }
		    finally{
		    	session.close();
		    }
		    return list;
			
		}
	  
	  @SuppressWarnings("unchecked")
	public List<Product> fetchDashboardProduct(List<Integer> productidList)
	  {
		  final Session session = this.getSessionFactory().openSession();
		  Transaction sessionTransaction = session.getTransaction();
		  List<Product> productList= null;
		  if (!sessionTransaction.isActive()) {
		      session.beginTransaction();
		    }
		  try{
			  
			  Query query = session.createQuery("from Product p where p.id in (:ids)");
			  query.setParameterList("ids", productidList);
			   productList = (query.list());
		  }catch(Exception e)
		  {
			  sessionTransaction.rollback();
		      System.out.println("CommonDAO fetchDashboardProduct failed");
		      e.printStackTrace();
		  }
		  finally{
			  session.close();
		  }
		  
		  return productList;
	  }
	  
	  public void removeAprioriRecords() 
		{

		  final Session session = this.getSessionFactory().openSession();
			 Transaction sessionTransaction = session.getTransaction();
			 if (!sessionTransaction.isActive()) {
		      session.beginTransaction();
		    }
		    try {
		    	System.out.println("Begin transaction");
		         String sql = "Truncate table AprioriRecord";
		         SQLQuery query = session.createSQLQuery(sql);
		         query.executeUpdate();
		         System.out.println("done");
		      sessionTransaction.commit();
		    } catch (Exception e) {
		    	sessionTransaction.rollback();
		      System.out.println("CommonDAO saveOrUpdate failed");
		      e.printStackTrace();
		    }
		    finally{
		    	session.close();
		    }
			
		} 

	  //query for search
	  
	  public List<Product> getSearchedProduct(String searchText)
	  {
		  	Criterion productName =Restrictions.ilike("name",searchText,MatchMode.ANYWHERE);
			Criterion description = Restrictions.ilike("description",searchText,MatchMode.ANYWHERE);
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(productName);
			disjunction.add(description);
		
			final Session session = this.getSessionFactory().openSession();
		 	final Criteria crit = session.createCriteria(Product.class);

		    try {
		    	
		     crit.add(disjunction);
		     List<Product> productList= crit.list();
		     return productList;

		     
		    } catch (final Exception e) {
		      System.out.println("find by criteria unique result with criteria failed");
		      e.printStackTrace();
		    }
		    finally{
		    	session.close();
		    }

		    return null;
			
	  }
	  
	  public void executedeletequery(String username)
	  {
		  final Session session = this.getSessionFactory().openSession();
		  Transaction sessionTransaction = session.getTransaction();
		  Query query = session.createQuery("delete from Usercart u where username = :username");
		  query.setParameter("username", username);
		  if (!sessionTransaction.isActive()) {
		      session.beginTransaction();
		    }
		  try{
			  int result = query.executeUpdate();
			  sessionTransaction.commit();
			  
			  if(result>0)
			  {
				  System.out.println("Record deleted succesfully");
			  }
			  
		  }catch(Exception e)
		  {
			  sessionTransaction.rollback();
			  e.printStackTrace();
		  }
		  finally{
			  session.close();
		  }
	  }

	@SuppressWarnings("unchecked")
	public List<AprioriRecord> fetchApriorirecordset(List<Integer> setId) {
		// TODO Auto-generated method stub
		 final Session session = this.getSessionFactory().openSession();
		  Transaction sessionTransaction = session.getTransaction();
		  List<AprioriRecord> productList= null;
		  if (!sessionTransaction.isActive()) {
		      session.beginTransaction();
		    }
		  try{
			  
			  Query query = session.createQuery("from AprioriRecord p where p.set_id in (:ids)");
			  query.setParameterList("ids", setId);
			   productList = (query.list());
		  }catch(Exception e)
		  {
			  sessionTransaction.rollback();
		      System.out.println("CommonDAO fetchDashboardProduct failed");
		      e.printStackTrace();
		  }
		  finally{
			  session.close();
		  }
		  
		  return productList;
	}
	
	  @SuppressWarnings("unchecked")
		public List<Product> fetchcartproduct(List<Integer> transactionid)
		  {
			  final Session session = this.getSessionFactory().openSession();
			  Transaction sessionTransaction = session.getTransaction();
			  List<Product> productList= null;
			  if (!sessionTransaction.isActive()) {
			      session.beginTransaction();
			    }
			  try{
				  
				  Query query = session.createQuery("from producttransaction where transaction_id in (:ids");
				  query.setParameterList("ids", transactionid);
				   productList = (query.list());
			  }catch(Exception e)
			  {
				  sessionTransaction.rollback();
			      System.out.println("CommonDAO fetchDashboardProduct failed");
			      e.printStackTrace();
			  }
			  finally{
				  session.close();
			  }
			  
			  return productList;
		  }
}
