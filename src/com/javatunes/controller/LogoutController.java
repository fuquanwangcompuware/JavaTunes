/*
 * Logout controller to handle user's logout request:
 * - invalidate the session
 * - return the login
 */

package com.javatunes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author amifxw0
 *
 */

// Mapped to /logout
@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	/**
	 * Handling HTTP GET request
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(HttpSession session) {
		
		// invalidate the session
		session.invalidate();
		
		// return to login
		return new ModelAndView("login", "login", new Login());
	}
}