/*
 * This is the Java Tunes Cart class providing methods for shopping cart operations:
 * 	- save shopping cart for user
 * 	- retrieve shopping cart information
 * 	- remove shopping cart when checked out
 */

package com.javatunes.bean;

public class JavaTunesCart {

	// DAO property for accessing database
	private CartDAO dao;

	/**
	 * Constructor with DAO
	 * @param daoIn
	 */
	public JavaTunesCart(CartDAO daoIn) {
		dao = daoIn;
	}
	
	/**
	 * Save the cart information
	 * @param cart
	 */
	public void saveCart(Cart cart) {
		
		if(dao.saveCart(cart)) {
			System.out.println("Successfully saved cart");
		} else {
			System.out.println("Failed to save cart");
		}
	}
	
	/**
	 * Retrieve shopping cart information for the given user name
	 * @param username
	 * @return shopping cart entity
	 */
	public Cart getCart(String username) {
		return dao.retrieveCart(username);
	}
	
	/**
	 * Remove the cart information by given a cart entity
	 * @param cart
	 */
	public void removeCart(Cart cart) {
		dao.removeCart(cart);
	}
}