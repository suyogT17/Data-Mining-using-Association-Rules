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
public class ProductTransaction {
private Integer id;
private Integer quantity;
private Integer transactionId;
private Integer productId;
private String productName;




@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

@Column(name="quantity")
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

@Column(name="transaction_id")
public Integer getTransactionId() {
	return transactionId;
}
public void setTransactionId(Integer transactionId) {
	this.transactionId = transactionId;
}
@Column(name="product_id")
public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}

@Column(name="product_name")
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}


}
