/*
 * Data Access Object interface for Shopping Cart
 */

package com.javatunes.bean;

public interface CartDAO {
	public boolean saveCart(Cart cart);
	public Cart retrieveCart(String userID);
	public boolean removeCart(Cart cart);
}