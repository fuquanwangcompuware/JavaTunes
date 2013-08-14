/*
 * Check out controller
 */
package com.javatunes.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatunes.bean.Cart;
import com.javatunes.bean.JavaTunesCart;
import com.javatunes.bean.JavaTunesCatalog;
import com.javatunes.bean.User;

// mapped to /checkout
@Controller
@RequestMapping("/checkout")
public class CheckOutController {

	@Autowired
	JavaTunesCart javaTunesCart;

	@Autowired
	JavaTunesCatalog catalog;

	/**
	 * Handling the HTTP GET request
	 * @param checkout
	 * @param request
	 * @param session
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(@ModelAttribute("checkout") Checkout checkout, HttpServletRequest request, HttpSession session) {
		
		Collection<ShoppingCart> collection = new ArrayList<ShoppingCart>();
		float totalPrice = 0.0f;

		// Check user's session, if not logged in return to login page
		User user = (User)session.getAttribute("user");
		if(user==null) {
			return new ModelAndView("login", "login", new Login());
		}
		
		// retrieve user's cart
		Cart cart = javaTunesCart.getCart(user.getUsername());

		if (cart != null) {
			
			// Resolve user's cart information, with a collection of music items and total price as output
			totalPrice = Util.resolveCartInfo(collection, cart, catalog);
			
			// Get user's state
			String userState = user.getState();
			
			// set properties
			checkout.setPriceBeforeTax(totalPrice);
			checkout.setTotalPrice(Util.calculatePriceAfterTax(userState,totalPrice));
			checkout.setTax(Util.round(totalPrice * Util.getTaxRateByState(userState), 2).floatValue());
			checkout.setResults(collection);
		}

		// Return to user's shopping cart view
		return new ModelAndView("shoppingCart");  
	}
	
	/**
	 * Handling HTTP POST request
	 * @param login
	 * @param request
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void processLogin(@ModelAttribute("checkout") Login login,
			HttpServletRequest request) {
		// do nothing for post
	}
}