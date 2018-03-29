package main.java.com.datamining.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="codeverification")
public class CodeVerification  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer userId ;
	private String verificationCode ;
	private String userName ;
		
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "verificationcode", unique = true, nullable = false)
	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	@Column(name = "username", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	
}
