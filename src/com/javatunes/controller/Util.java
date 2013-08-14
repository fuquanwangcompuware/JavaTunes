/*
 * Utility
 */

package com.javatunes.controller;

import java.math.BigDecimal;
import java.util.Collection;

import com.javatunes.bean.Cart;
import com.javatunes.bean.Catalog;
import com.javatunes.bean.MusicItem;
import com.javatunes.bean.TaxTable;

public class Util {

	/**
	 * Resolve user's cart information by converting String cart detail
	 * m:n,m:n... to a collection of music items and total price
	 * 
	 * @param collection
	 * @param cart
	 * @return total price
	 */
	public static float resolveCartInfo(Collection<ShoppingCart> collection,
			Cart cart, Catalog catalog) {
		String cartDetail = cart.getCartDetail();
		float totalPrice = 0.0f;

		// resolve user's cart
		String cartArray[] = cartDetail.split(",");
		for (int i = 0; i < cartArray.length; i++) {

			// loop for each music item
			String cartItem = cartArray[i];

			// get music item id
			long musicItemID = Long.parseLong(cartItem.split(":")[0]);

			// get music item quantity
			int musicItemQuantity = Integer.parseInt(cartItem.split(":")[1]);

			// Find music item by ID
			MusicItem mi = catalog.findById(musicItemID);

			// Calculate price
			float price = mi.getPrice().floatValue()
					* (float) musicItemQuantity;

			// Set properties
			ShoppingCart sc = new ShoppingCart();
			sc.setItemID(musicItemID);
			sc.setItemName(mi.getTitle());
			sc.setArtist(mi.getArtist());
			sc.setQuantity(musicItemQuantity);

			// Add music item to collection
			collection.add(sc);

			// sum the total price
			totalPrice += price;
		}
		return totalPrice;
	}
	
	/**
	 * Calc price after tax
	 * @param taxRate
	 * @param totalPrice
	 * @return tax
	 */
	public static float calculatePriceAfterTax(String userState, float totalPrice) {
		// get user's state tax rate
		float taxRate = getTaxRateByState(userState);
		return round(totalPrice * (1+taxRate), 2).floatValue();
	}
	
	/**
	 * get tax rate upon state
	 * @param state
	 * @return tax rate
	 */
	public static float getTaxRateByState(String state) {
		return TaxTable.getTaxRate(state);
	}
	
	/**
	 * Utitly to round price/tax
	 * @param d
	 * @param decimalPlace
	 * @return rounded price/tax
	 */
	public static BigDecimal round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
        return bd;
    }
}
