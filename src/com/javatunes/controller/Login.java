/*
 * Data Model for user's login
 */

package com.javatunes.controller;

import java.util.Collection;

import com.javatunes.bean.MusicItem;

/**
 * 
 * @author amifxw0
 *
 */
public class Login {
	
	// User's login name
	private String username;
	
	// User's password
	private String password;
	
	// User's default 20 music items
	private Collection<MusicItem> results;

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
	
	// getter for user's first 20 items
	public Collection<MusicItem> getResults() {
		return results;
	}
	
	// setter for user's first 20 items
	public void setResults(Collection<MusicItem> results) {
		this.results = results;
	}
	
	// validate user's login to make sure username & password are not empty
	public String validateLogin() {
		if(username==null || password==null || username.length()==0 || password.length()==0) {
			return "Fields cannot be empty";
		}
		return null;
	}
}
