/*
 * Data Model for adding one music item to shopping cart, inclues:
 *  - music item id
 *  - music item name
 *  - musci item artist
 *  - total price for user's shopping cart
 *  - quantity 
 */

package com.javatunes.controller;

public class ShoppingCart {
	
	// Music item ID
	private long itemID;
	
	// Music item name
	private String itemName;
	
	// Music item artist
	private String artist;
	
	// Music item total price
	private float totalPrice;
	
	// Music item quantity
	private int quantity;
	
	
	// getter for item name
	public String getItemName() {
		return itemName;
	}
	
	// setter for item name
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	// getter for item quantity
	public int getQuantity() {
		return quantity;
	}
	
	// setter for item quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// getter for item price
	public float getTotalPrice() {
		return totalPrice;
	}

	// setter for item price
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	// getter for item id
	public long getItemID() {
		return itemID;
	}

	// setter for item id
	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	// getter for item artist
	public String getArtist() {
		return artist;
	}

	// setter for item artist
	public void setArtist(String artist) {
		this.artist = artist;
	}
}