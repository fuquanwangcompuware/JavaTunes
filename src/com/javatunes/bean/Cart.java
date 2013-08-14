/*
 * This is the Bean for Shopping Cart, includes:
 * username - connects to a user
 * cart detail - specifies cart information in following format
 * 
 * itemID:quantity,itemID:quantity...
 */

package com.javatunes.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")

/*
 * Entity name - Cart
 */

public class Cart implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	// Properties
	
	/**
	 * Username - String
	 * Primary key
	 */
	@Id
	@Column(name = "Username")
	private String userName;
	
	/*
	 * Cart Detail
	 */
	@Column(name = "Cart")
	private String cartDetail;
	
	/*
	 * Default Constructor
	 */
	public Cart() {
	}

	/**
	 * Constructor with full properties
	 * @param username
	 * @param cart
	 */
	public Cart(String username, String cart) {
		this.serUsername(username);
		this.setCartDetail(cart);
	}

	/**
	 * Override the toString() from Object for printing information
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + ": userID=" + this.getUsername()
				+ ": cartDetail=" + this.getCartDetail();
	}

	/**
	 * Cart detail getter
	 * @return cart detail information
	 */
	public String getCartDetail() {
		return cartDetail;
	}

	/**
	 * Cart detail setter
	 * @param cart
	 */
	public void setCartDetail(String cart) {
		this.cartDetail = cart;
	}

	/**
	 * getter for user name
	 * @return user name
	 */
	public String getUsername() {
		return this.userName;
	}

	/**
	 * setter for user name
	 * @param username
	 */
	public void serUsername(String username) {
		this.userName = username;
	}
}
