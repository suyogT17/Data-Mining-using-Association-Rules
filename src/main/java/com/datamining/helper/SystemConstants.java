package main.java.com.datamining.helper;

public interface SystemConstants {

	public static final String		VERIFICATION_CODE_EMAIL_BODY	= "<html></body>Dear FirstName ,"
			+ "<p>Your Registration request has been processed."
			+"<br>Username is: <b>userid</b>."
			+ "<br>Your Verification code is: <b>autoGenCode</b>."
			+ "<br><br>Should you require any assistance, please do not hesitate to contact us on custcareshoppingmania@gmail.com"
			+ "<p>Regards,<br/>Shopping Mania Team</p>"
			+ "<p><em>Note: This is automated email notification from Shopping Mania. Please do not reply to this email.</em></p></body></html>";
	
	public static final String 		VERIFICATION_CODE_EMAIL_SUBJECT = "User Registration Verification Code";
	
	
	
	public static final String  REGISTRATION_COMPLETE_EMAIL_BODY="<html></body>Dear FirstName ,"
			+"<p>You have successfully Registered on Shopping Mania"
			+"<br>Thanks for Being our Custumer"
			+"<br>We hope you enjoy shopping on Shopping Mania"
			+ "<br><br>Should you require any assistance, please do not hesitate to contact us on custcareshoppingmania@gmail.com"
			+"<p>Regards,<br/>Shopping Mania Team</p>"
			+ "<p><em>Note: This is automated email notification from Shopping Mania. Please do not reply to this email.</em></p></body></html>";
	
	public static final String 		REGISTRATION_COMPLETE_EMAIL_SUBJECT = "User Registered Successfully";
	
	
	
	public static final StringBuffer  ORDER_CONFIRMATION_MAIL=new StringBuffer("<html></body>"
						+"<p><p>Your Order Will be dispatched soon"
						+"<br>Thanks for Shopping on Shopping Mania"
						+"<br><br>Your Order Summary is: <br>"
						+"</body></html>");

public static final String 		SHOP_COMPLETE_EMAIL_SUBJECT = "Order Dispatched Successfully";

	
	
	
	public static final String IMAGE_PATH ="D:\\myfolderporj\\datamining\\WebContent\\resources\\images\\";

	public static final String USER_ROLE = "ROLE_USER";
	
	public static final String USER_ADMIN = "ROLE_ADMIN";

	public static final String CUST_QUERY = "Customer Service";
	
	public static final String CUST_QUERY_EMAIL_BODY="<html><body>name: FirstName ,"
		+"<p>feedback:</p>"
		+"<p>message</p></body></html>";
}

