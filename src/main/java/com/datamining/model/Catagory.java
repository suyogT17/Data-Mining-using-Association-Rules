package main.java.com.datamining.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="catagory")
public class Catagory {
private Integer cid;
private String description;
private Set<Product> product = new HashSet<Product>(0);


@OneToMany(mappedBy="catagory")

public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}

@Column
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


}
