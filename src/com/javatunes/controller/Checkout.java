/*
 * Data Model for checkout, includes:
 * - collection of user's shopping cart items
 * - total price
 * - price before tax
 * - tax
 */

package com.javatunes.controller;

import java.util.Collection;

/**
 * 
 * @author amifxw0
 *
 */
public class Checkout {
	
	// user's shopping cart collection
	private Collection<ShoppingCart> results;
	
	// total price after tax
	private float totalPrice;
	
	// price beofre tax
	private float priceBeforeTax;
	
	// tax
	private float tax;

	
	// getter for shopping cart items
	public Collection<ShoppingCart> getResults() {
		return results;
	}
	
	// setter for shopping cart items
	public void setResults(Collection<ShoppingCart> results) {
		this.results = results;
	}

	// getter for total price after tax
	public float getTotalPrice() {
		return totalPrice;
	}

	// setter for total price after tax
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	// getter for total price beofer tax
	public float getPriceBeforeTax() {
		return priceBeforeTax;
	}

	// setter for total price beofer tax
	public void setPriceBeforeTax(float priceBeforeTax) {
		this.priceBeforeTax = priceBeforeTax;
	}

	// getter for tax
	public float getTax() {
		return tax;
	}

	// setter for tax
	public void setTax(float tax) {
		this.tax = tax;
	}
}
