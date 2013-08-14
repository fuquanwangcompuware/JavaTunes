/*
 * Controller for User's login
 */

package com.javatunes.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatunes.bean.Catalog;
import com.javatunes.bean.JavaTunesUser;
import com.javatunes.bean.Lang;
import com.javatunes.bean.User;

// Mapped to /login
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	JavaTunesUser javaTunesUser;
	
	@Autowired
	Catalog catalog;
	
	@Autowired
	Lang lang;

	/**
	 * Handling HTTP GET request, set locale to default English
	 * @param login
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("login") Login login, HttpSession session) {
		loadLocale(session, "en");
		return "login";
	}

	/**
	 * Handing HTTP POST request to check user's credential
	 * If good checking then set the locale upon user's preference
	 * @param login
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("login") Login login, HttpServletRequest request, HttpSession session) {

		String username = login.getUsername();
		String password = login.getPassword();
		
		System.out.println("username:" + (username.length()==0?"<empty>":username));
		System.out.println("password:" + (password.length()==0?"<empty>":password));
		
		String errorMessage = login.validateLogin();
		if(errorMessage!=null) {
			request.setAttribute("errorMessage", errorMessage);
			return "login";
		}
		
		// Check user's credential
		User user = javaTunesUser.findByUsernamePassword(username, password);
		
		// if credential checking failed, return error message to login
		if(user==null) {
			errorMessage = "Invalid username/password combination";
			request.setAttribute("errorMessage", errorMessage);
			return "login";
		}
		
		// if credential check good, then load the first 20 items in user's page
		login.setResults(catalog.findFirstTwenty());
		
		// set user's session as logged in
		session.setAttribute("user", user);
		
		// load locale for user
		System.out.println("Setting to language: " + user.getLanguage());
		loadLocale(session, user.getLanguage());
		
		// return to user's index page
		return "index";
	}
	
	/**
	 * load locale by given sessin and language request
	 * @param session
	 * @param language
	 */
	private void loadLocale(HttpSession session, String language) {
		// load language
		lang.loadLang(language);
		Map<String, String> langMap = lang.getMap();
		
		// set locale in session
		session.setAttribute("langMap", langMap);
	}
}