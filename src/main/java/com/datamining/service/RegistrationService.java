package main.java.com.datamining.service;

import java.util.Date;

import main.java.com.datamining.dao.CommonDAO;
import main.java.com.datamining.dto.UserRegistrationDTO;
import main.java.com.datamining.helper.Helper;
import main.java.com.datamining.helper.SystemConstants;
import main.java.com.datamining.model.Address;
import main.java.com.datamining.model.CodeVerification;
import main.java.com.datamining.model.Role;
import main.java.com.datamining.model.User;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RegistrationService {
	
	@Autowired
	private CommonDAO commondao;

	public void insertregistrant(UserRegistrationDTO userreg)
	{
		User u = this.getUser(userreg);
		Address addr = this.getAddress(userreg);
		
		try {
			Integer id=commondao.create(u);
			u.setUserid(id);
			addr.setUser(u);
			commondao.create(addr);
			this.sendRegistrationConfirmationEmail(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void sendRegistrationConfirmationEmail(User u) {

		String body =SystemConstants.REGISTRATION_COMPLETE_EMAIL_BODY;
		String mailbody =body.replaceAll("FirstName", u.getFirstname());
		String subject = SystemConstants.REGISTRATION_COMPLETE_EMAIL_SUBJECT;
		String emailId= u.getEmailid();
		EmailService.sendEmaill(mailbody, subject, emailId);
	}

	private Address getAddress(UserRegistrationDTO userreg) {
		Address adr = new Address();
		adr.setAddressLine1(userreg.getAddressline1());
		adr.setAddressLine2(userreg.getAddressline2());
		adr.setCity(userreg.getCity());
		adr.setCountry(userreg.getCountry());
		adr.setLandmark(userreg.getLandmark());
		adr.setPinno(userreg.getPinno());
		adr.setState(userreg.getState());
		adr.setStreet(userreg.getStreet());
		return adr;
	}

	private User getUser(UserRegistrationDTO userreg) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(userreg.getUsername());
		user.setContactnumber(userreg.getContactnumber());
		user.setCreationdate(new Date());
		user.setEmailid(userreg.getEmailid());
		user.setFirstname(userreg.getFirstname());
		user.setLastname(userreg.getLastname());
		user.setPassword(userreg.getPassword());
		user.setEnabled(true);
		Role role = new Role();
		role.setRole_ID(2);
		user.setRole(role);
		return user;
	}

	public void generateverificationcode(String username,String emailId) throws Exception {
		// TODO Auto-generated method stub
		CodeVerification code = new CodeVerification();
		String pin=Helper.generatePin();
		code.setUserName(username);
		code.setVerificationCode(pin);
		commondao.saveOrUpdate(code);
		String body =SystemConstants.VERIFICATION_CODE_EMAIL_BODY;
		String mailBody=body.replaceAll("FirstName", username).replaceAll("userid", username).replaceAll("autoGenCode", pin);
		
		String subject = SystemConstants.VERIFICATION_CODE_EMAIL_SUBJECT;
		
		EmailService.sendEmaill(mailBody, subject,emailId);
		
	}

	public String verifyuser(String username, String code) {
		// TODO Auto-generated method stub
		String status = null;
		Criterion cr = Restrictions.eq("userName", username);
		
		try {
			CodeVerification verification = (CodeVerification) commondao.findByCriteriaUniqueResultWithCritera(new CodeVerification(), null, cr);
			if(null!=verification)
			{
				if(code.equals(verification.getVerificationCode()))
				{
					return "success";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		
		return "failure";
	
	}
}
