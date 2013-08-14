/*
 * Data Model for user registration
 * - user's login name
 * - user's login password
 * - user's login password repeated checking
 * - user's first name
 * - user's last name
 * - user's address
 * - user's state
 * - user's zip code
 * - user's language preference 
 */

package com.javatunes.controller;

public class Register {
	
	// user's login name
	private String username;
	
	// user's login password
	private String password;
	
	// user's password repeat checking
	private String repeatPassword;
	
	// first name
	private String firstname;
	
	//last name
	private String lastname;
	
	// address
	private String address;
	
	// state
	private String state;
	
	// zip code
	private String zipCode;
	
	// language
	private String language;
	
	// getter for user login name
	public String getUsername() {
		return username;
	}

	// setter for user login name
	public void setUsername(String keyword) {
		this.username = keyword;
	}

	// getter for user login password
	public String getPassword() {
		return password;
	}

	// setter for user login password
	public void setPassword(String password) {
		this.password = password;
	}

	// getter for user repeat password
	public String getRepeatPassword() {
		return repeatPassword;
	}

	// setter for user repeat password
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	// getter for user address
	public String getAddress() {
		return address;
	}

	// setter for user address
	public void setAddress(String address) {
		this.address = address;
	}

	// getter for user state
	public String getState() {
		return state;
	}

	// setter for user state
	public void setState(String state) {
		this.state = state;
	}

	// getter for user zip code
	public String getZipCode() {
		return zipCode;
	}

	// setter for user zip code
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	// getter for user language preference
	public String getLanguage() {
		return language;
	}

	// setter for user preference
	public void setLanguage(String language) {
		this.language = language;
	}
	
	// Registration validation:
	// - no fields are empty
	// - two passwords should match
	public String validateRegistration() {
		
		// Check empty fields
		if(username.length()==0 
				|| password.length()==0 
				|| repeatPassword.length()==0
				|| address.length()==0
				|| state.length()==0
				|| zipCode.length()==0
				|| language.length()==0) {
			return "Please fill the mandatory fields";
		} 
		
		// Check passwords matchs
		if(!password.equals(repeatPassword)) {
			return "The two passwords should be the same";
		}
		return null;
	}

	// getter for user first name
	public String getFirstname() {
		return firstname;
	}

	// setter for user first name
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	// getter for user last name
	public String getLastname() {
		return lastname;
	}

	// setter for user last name
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}