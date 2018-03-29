package main.java.com.datamining.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AprioriRecord {
private Integer AR_id;
private Integer Set_id;
private Integer product_id;
private Integer minSupport;

@Column(name="min_support")
public Integer getMinSupport() {
	return minSupport;
}
public void setMinSupport(Integer minSupport) {
	this.minSupport = minSupport;
}

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column
public Integer getAR_id() {
	return AR_id;
}
public void setAR_id(Integer aR_id) {
	AR_id = aR_id;
}

@Column
public Integer getSet_id() {
	return Set_id;
}
public void setSet_id(Integer set_id) {
	Set_id = set_id;
}

@Column
public Integer getProduct_id() {
	return product_id;
}
public void setProduct_id(Integer product_id) {
	this.product_id = product_id;
}


}
