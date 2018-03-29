package main.java.com.datamining.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.dto.TransactionDTO;
import main.java.com.datamining.helper.Helper;
import main.java.com.datamining.helper.SystemConstants;
import main.java.com.datamining.model.CartList;
import main.java.com.datamining.model.Product;
import main.java.com.datamining.model.ProductTransaction;
import main.java.com.datamining.model.Transaction;
import main.java.com.datamining.model.User;
import main.java.com.datamining.model.UserCartdto;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;



@Service
public class TransactionService {
	@Autowired
	private CartService cartService;
	@Autowired
	private CommonDAO commonDAO;
	
	public Integer createTransaction(List<UserCartdto> usercartdto,int total )
	{
		System.out.println("total1="+total);
		String userName = Helper.getUsername();
		Transaction t = new Transaction();
		t.setAmount(total);
		t.setDate(new Date());
		t.setUserName(userName);
		int transactionId;
		try {
			transactionId=commonDAO.create(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		for(UserCartdto d : usercartdto)
		{
			ProductTransaction pt = new ProductTransaction();
			Product product=new Product();
			//pt.setProductId(d.getProductId());
			//System.out.println("product id i get is"+d.getProductId());
			pt.setQuantity(d.getQuantity());
			pt.setTransactionId(transactionId);
			pt.setProductName(d.getProductName());
			Criterion crt = Restrictions.eq("name",d.getProductName() );
			
			try {
				product = (Product) commonDAO.findByCriteriaUniqueResultWithCritera(product, null, crt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pt.setProductId(product.getId());
			System.out.println("product id i get is"+product.getId());
			try {
				commonDAO.create(pt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//int total1=total;
		this.sendOrdersummarymail(usercartdto); 
		
		return transactionId;
	}
	
	@SuppressWarnings("unchecked")
	public List<TransactionDTO> getTransactionList()
	{
		List<TransactionDTO> transactionlist = new ArrayList<TransactionDTO>();
		List<Transaction> transactionlst = commonDAO.getObjectList(new Transaction());
		for(Transaction t : transactionlst)
		{
			Criterion cr = Restrictions.eq("transactionId", t.getId());
			try {
				List<ProductTransaction> productTransactionList = (List<ProductTransaction>) commonDAO.findByCriteria(new ProductTransaction(), null, cr);
				for(ProductTransaction pt : productTransactionList )
				{
					TransactionDTO td = new TransactionDTO();
					td.setProductName(pt.getProductName());
					td.setQuantity(pt.getQuantity());
					td.setUsername(t.getUserName());
					td.setTransactionid(pt.getTransactionId());
					transactionlist.add(td);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return transactionlist;
	}

	
	public void sendOrdersummarymail(List<UserCartdto> usercartdto) {
		// TODO Auto-generated method stub
	
	
		int total=0;
		
		for(UserCartdto d : usercartdto)
		{	
			SystemConstants.ORDER_CONFIRMATION_MAIL.append("<br>");
			SystemConstants.ORDER_CONFIRMATION_MAIL.append("product name:"+d.getProductName());
			SystemConstants.ORDER_CONFIRMATION_MAIL.append("<br>");

			SystemConstants.ORDER_CONFIRMATION_MAIL.append("product price:"+d.getPrice());
			SystemConstants.ORDER_CONFIRMATION_MAIL.append("<br>");

			SystemConstants.ORDER_CONFIRMATION_MAIL.append("product quantity:"+d.getQuantity());
			SystemConstants.ORDER_CONFIRMATION_MAIL.append("<br>");

			if(null!=d && null!=d.getPrice())
			{
				total=total+(d.getPrice()*d.getQuantity());
				
			}
		}
		SystemConstants.ORDER_CONFIRMATION_MAIL.append("Total"+total);
		
		this .sendOrder();
	}

	private void sendOrder() {
		// TODO Auto-generated method stub
		
		StringBuffer body =SystemConstants.ORDER_CONFIRMATION_MAIL;
		/*String mailbody =body.replaceAll("FirstName", u.getFirstname());*/
		String subject = SystemConstants.SHOP_COMPLETE_EMAIL_SUBJECT;
		String  username=Helper.getUsername();
		User user = null;
		Criterion crt = Restrictions.eq("username", username);
		
		try {
			user = (User) commonDAO.findByCriteriaUniqueResultWithCritera(new User(), null, crt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String emailId=user.getEmailid();
		System.out.println("email id stored");
		System.out.println("email="+emailId);
		EmailService.sendEmaill(body.toString(), subject, emailId);
		System.out.println("email sent");
	}

	
}




