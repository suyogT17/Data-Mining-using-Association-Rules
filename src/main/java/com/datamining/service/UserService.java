package main.java.com.datamining.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.dto.UserRegistrationDTO;
import main.java.com.datamining.helper.Helper;
import main.java.com.datamining.helper.SystemConstants;
import main.java.com.datamining.model.Address;
import main.java.com.datamining.model.Role;
import main.java.com.datamining.model.User;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private CommonDAO commonDAO;
	
	
	
	public List<User> getAllActiveUsers()
	{
		Criterion cr = Restrictions.eq("enabled", true);
		try {
			List<User> userList = (List<User>) commonDAO.findByCriteria(new User(), null, cr);
			return userList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateuser(User user)
	{
		try {
			Role role = new Role();
			role.setRole_ID(2);
			user.setRole(role);
			 commonDAO.saveOrUpdate(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteuser(User user)
	{
		try {
			
			user.setEnabled(false);
			 commonDAO.saveOrUpdate(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getJsonString(Object object) {
		// TODO Auto-generated method stub
		String json = null;
        ObjectMapper objectmapper = new ObjectMapper();
        try {
        json = objectmapper.writeValueAsString(object);
        } catch (JsonGenerationException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        } catch (JsonMappingException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
        return json;
	}
	
	public User fetchUser(String username)
	{
		User user = null;
		Criterion cr = Restrictions.eq("username", username);
		try {
			user = (User) commonDAO.findByCriteriaUniqueResultWithCritera(new User(), null, cr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public UserRegistrationDTO getregistrationDetails1() 
	{
		// TODO Auto-generated method stub
		 UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO(); 
		 //Address add = new Address() ;
		String username = Helper.getUsername();
		User user = null;
	
		
		Criterion cr = Restrictions.eq("username", username);
		try {
			user = (User) commonDAO.findByCriteriaUniqueResultWithCritera(new User(), null, cr);
			if(null!=user)
			{
				userRegistrationDTO.setUsername(user.getUsername());
				userRegistrationDTO.setEmailid(user.getEmailid());
				userRegistrationDTO.setFirstname(user.getFirstname());
				userRegistrationDTO.setUserid(user.getUserid());
				userRegistrationDTO.setContactnumber(user.getContactnumber());
				

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		/*	return "failure";
			*/
		}
		
				return userRegistrationDTO;
	}
	

/*	 public UserRegistrationDTO getregistrationDetails() {
		// TODO Auto-generated method stub
		 
		 UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
		

		User user = new User() ;
		userRegistrationDTO.setUsername(user.getUsername());

		userRegistrationDTO.setEmailid(user.getEmailid());
		userRegistrationDTO.setFirstname(user.getFirstname());

		userRegistrationDTO.setContactnumber(user.getContactnumber());
		
	    Address add = new Address() ;
		userRegistrationDTO.setAddressline1(add.getAddressLine1());
		userRegistrationDTO.setAddressline2(add.getAddressLine2());
		
		return userRegistrationDTO;
		}
*/


	public String updatepassword(String password) 
	{
		// TODO Auto-generated method stub
		String username = Helper.getUsername();
		User user = null;
		Criterion cr = Restrictions.eq("username", username);
		try {
			user = (User) commonDAO.findByCriteriaUniqueResultWithCritera(new User(), null, cr);
			if(null!=user)
			{
				user.setPassword(password);
				commonDAO.saveOrUpdate(user);
				return "success";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}

//	public static void orderconfirmationemail(User u) {
//		// TODO Auto-generated method stub
//		
//		String body =SystemConstants.SHOP_COMPLETE_EMAIL_BODY;
//		String mailbody =body.replaceAll("FirstName", u.getFirstname());
//		String subject = SystemConstants.SHOP_COMPLETE_EMAIL_SUBJECT;
//		String emailId= u.getEmailid();
//		EmailService.sendEmaill(mailbody, subject, emailId);
//		
//	}
/*
	public UserRegistrationDTO getregistrationDetails(){ 
		// TODO Auto-generated method stub
		
		UserRegistrationDTO d= new UserRegistrationDTO();
		try{
		d.setAddressline1(d.getAddressline1());
		}
		catch (Exception e) {
			// TODO: handle exception
			updatepassword("123");
		}
		
		return getregistrationDetails();
	}
	
*/

	public UserRegistrationDTO getregistrationDetails() 
	{
		// TODO Auto-generated method stub
		 UserRegistrationDTO userRegistrationDTO=getregistrationDetails1();;
	
		 //Address add = new Address() ;
		//String username = Helper.getUsername();
		Address add = null;
		
System.out.println("id"+userRegistrationDTO.getUserid());
		
	
		
		Criterion cr = Restrictions.eq("user.userid", userRegistrationDTO.getUserid());
		try {
			add = (Address) commonDAO.findByCriteriaUniqueResultWithCritera(new Address(), null, cr);
			if(null!=add)
			{
			
				userRegistrationDTO.setAddressline1(add.getAddressLine1());
				userRegistrationDTO.setAddressline2(add.getAddressLine2());
			
				System.out.println("pass");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fail");
		/*	return "failure";
			*/
		}
		
				return userRegistrationDTO;
	}
	
}


