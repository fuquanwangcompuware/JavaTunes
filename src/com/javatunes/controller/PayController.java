/*
 * Pay controller to simulate user's payment activity:
 * - clear user's cart
 */

package com.javatunes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatunes.bean.Cart;
import com.javatunes.bean.JavaTunesCart;
import com.javatunes.bean.JavaTunesUser;
import com.javatunes.bean.User;

// Mapped to /pay
@Controller
@RequestMapping("/pay")
public class PayController {

	@Autowired
	JavaTunesCart javaTunesCart;

	@Autowired
	JavaTunesUser javaTunesUser;

	/**
	 * Handing HTTP GET request clear user's cart info
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(HttpSession session, HttpServletRequest request) {
		
		// Retrieve user's information from session
		User user = (User)session.getAttribute("user");
		
		// Go back to login if user not logged in
		if(user==null) {
			return new ModelAndView("login", "login", new Login());
		}
		
		// Retrieve user's cart information based user name
		Cart cart = javaTunesCart.getCart(user.getUsername());
		
		if(cart!=null) {
			
			// Remove user's cart as payed
			javaTunesCart.removeCart(cart);
			
			// Set success message for order placement
			request.setAttribute("payMessage", "Order placed successfully");
		}
		
		// return to search page after order placed
		return new ModelAndView("searchForm", "search", new Search());
	}
}