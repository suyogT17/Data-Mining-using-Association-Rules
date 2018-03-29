package main.java.com.datamining.model;

import java.util.List;

public class CartList {
	
	private List<UserCartdto> cartProductList ;
	private int totalprice;
	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public List<UserCartdto> getCartProductList() {
		return cartProductList;
	}

	public void setCartProductList(List<UserCartdto> cartProductList) {
		this.cartProductList = cartProductList;
	}

}
