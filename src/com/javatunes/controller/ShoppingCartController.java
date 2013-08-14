/*
 * Controller for adding item to shopping cart
 * It does not return to any view but will be called by jQuery AJAX request
 */

package com.javatunes.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatunes.bean.Cart;
import com.javatunes.bean.JavaTunesCart;
import com.javatunes.bean.User;

/**
 * Mapped to /addToShoppingCart
 * @author amifxw0
 *
 */
@Controller
@RequestMapping("/addToShoppingCart")
public class ShoppingCartController {

	@Autowired
	JavaTunesCart javaTunesCart;

	/**
	 * Handle user's HTTP GET request to persist user's shopping cart
	 * 
	 * @param cart
	 * @param request
	 * @param response
	 * @param session
	 * @throws ServletException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void get(@ModelAttribute("shoppingCart") ShoppingCart cart, HttpServletRequest request, HttpServletResponse response, HttpSession session) 
			throws ServletException, IOException, InterruptedException{
		
		// Retrieve user's information from session
		User user = (User)session.getAttribute("user");
		
		// persist the cart
		javaTunesCart.saveCart(new Cart(user.getUsername(),  "," + cart.getItemID() + ":" + cart.getQuantity()));
		
		// write message back to jQuery AJAX request
		response.getWriter().write("done");   
	}
}