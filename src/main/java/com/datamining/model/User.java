package main.java.com.datamining.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="user")
public class User {
private int Userid;
private String Username;
private String Firstname;
private String Lastname;
private String Contactnumber;
private String Emailid;
private String Password;
private Date Creationdate;
private boolean					enabled;
private boolean					accExpired;
private boolean					credentialsExpired;
private boolean					accountLocked;
private Role role; 

private Set<Address> Address= new HashSet<Address>(0);


@JsonIgnore
@OneToMany(mappedBy="user")
public Set<Address> getAddress_table() {
	return Address;
}
public void setAddress_table(Set<Address> address_table) {
	Address = address_table;
}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column
public int getUserid() {
	return Userid;
}

@JsonIgnore
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="Role_ID",nullable=false)
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public void setUserid(int userid) {
	Userid = userid;
}

@Column
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
@Column
public String getFirstname() {
	return Firstname;
}
public void setFirstname(String firstname) {
	Firstname = firstname;
}

@Column
public String getLastname() {
	return Lastname;
}
public void setLastname(String lastname) {
	Lastname = lastname;
}

@Column
public String getContactnumber() {
	return Contactnumber;
}
public void setContactnumber(String contactnumber) {
	Contactnumber = contactnumber;
}
@Column
public String getEmailid() {
	return Emailid;
}
public void setEmailid(String emailid) {
	Emailid = emailid;
}
@Column
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

@Temporal(TemporalType.TIMESTAMP)
@Column
public Date getCreationdate() {
	return Creationdate;
}
public void setCreationdate(Date Creationdate) {
	this.Creationdate = Creationdate;
}

@Column(name = "enabled")
public boolean isEnabled()
{
	return this.enabled;
}

public void setEnabled(final boolean enabled)
{
	this.enabled = enabled;
}

@Column(name = "acc_expired", nullable = false)
public boolean isAccExpired()
{
	return this.accExpired;
}

public void setAccExpired(final boolean accExpired)
{
	this.accExpired = accExpired;
}

@Column(name = "credentials_expired")
public boolean isCredentialsExpired()
{
	return this.credentialsExpired;
}

public void setCredentialsExpired(final boolean credentialsExpired)
{
	this.credentialsExpired = credentialsExpired;
}

@Column(name = "account_locked")
public boolean isAccountLocked()
{
	return this.accountLocked;
}

public void setAccountLocked(final boolean accountLocked)
{
	this.accountLocked = accountLocked;
}
        
}
