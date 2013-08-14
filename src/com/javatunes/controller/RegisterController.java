/*
 * Controller for user registration
 */
package com.javatunes.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatunes.bean.JavaTunesUser;
import com.javatunes.bean.User;

/*
 * Mapped to /register URL
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	JavaTunesUser javaTunesUser;

	/**
	 * Handling HTTP GET request - sends to register page
	 * @param register
	 * @return register page
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("register") Register register) {
		return "register";
	}

	/**
	 * Handing HTTP POST request to register the user
	 *  - check fields
	 *  - persist
	 * @param register
	 * @param request
	 * @return user view
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processRegister(@ModelAttribute("register") Register register, 
			HttpServletRequest request) {
		
		// Retrieve fields
		String username = register.getUsername();
		String password = register.getPassword();
//		String repeatPassword = register.getRepeatPassword();
		
		String firstname = register.getFirstname();
		String lastname = register.getLastname();
		
		String address = register.getAddress();
		String state = register.getState();
		String zipCode = register.getZipCode();
		String country = register.getLanguage();
		
		// Validate form information
		String errorMessage = register.validateRegistration();
		
		// If failed return to register with error message
		if(errorMessage!=null) {
			request.setAttribute("errorMessage", errorMessage);
			return new ModelAndView("register");
		}
		
		// persist user
		User user = javaTunesUser.addUser(new User(username, password, firstname, lastname, address, state, zipCode, country));
		
		if(user!=null) {
			System.out.println("User registered ===> " + user.toString());
			return new ModelAndView("login", "login", new Login());
		} else {
			errorMessage = "User name: " + username + " already exists";
		}
		
		// if anything failed return to register with error message
		request.setAttribute("errorMessage", errorMessage);
		return new ModelAndView("register");
	}
}