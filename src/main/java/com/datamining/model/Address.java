package main.java.com.datamining.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table
public class Address {
private Integer addressId;
private String addressLine1;
private String addressLine2;

private String street;
private String landmark;
private String city;
private String state;
private String country;
private String pinno;
private User user;

@ManyToOne
@JoinColumn(name="Userid",nullable=false)
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column
public Integer getAddressId() {
	return addressId;
}
public void setAddressId(Integer addressId) {
	this.addressId = addressId;
}

@Column(name="addressline1")
public String getAddressLine1() {
	return addressLine1;
}
public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}

@Column(name="addressline2")
public String getAddressLine2() {
	return addressLine2;
}
public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}

@Column(name="street")
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}

@Column(name="landmark")
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}

@Column(name="city")
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

@Column(name="state")
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

@Column(name="country")
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

@Column(name="pinno")
public String getPinno() {
	return pinno;
}
public void setPinno(String pinno) {
	this.pinno = pinno;
}




}
