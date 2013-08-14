/*
 * User bean defines Java Tunes user's properties and getters/setters
 * 
 * 	- username: user login name
 * 	- password: user login password
 * 	- first name
 * 	- last name
 * 	- address
 * 	- state: determines the tax rate
 * 	- zip code
 * 	- language: determines the language support for user
 */

package com.javatunes.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * relies on users table
 * @author amifxw0
 *
 */
@Entity
@Table(name = "users")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	// Properties
	
	// user login username - primary key
	@Id
	@Column(name = "username")
	private String username;
	
	// user login password
	@Column(name = "password")
	private String password;
	
	// first name
	@Column(name = "firstname")
	private String firstname;
	
	// last name
	@Column(name = "lastname")
	private String lastname;
	
	// address
	@Column(name = "address")
	private String address;

	// state
	@Column(name = "stateof")
	private String state;

	// zip code
	@Column(name = "zipCode")
	private String zipCode;
	
	// language preference
	@Column(name = "LanguagePreference")
	private String language;
	
	
	/**
	 * Constructor without parameters
	 */
	public User() {
	}

	/**
	 * Constructor with full parameters
	 * 
	 * @param username
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param state
	 * @param zipCode
	 * @param language
	 */
	public User(String username, String password, String firstname, String lastname, String address, String state, String zipCode, String language) {
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setAddress(address);
		this.setState(state);
		this.setZipCode(zipCode);
		this.setLanguage(language);
	}

	/**
	 * Overriding the Object.toString() to print the first name
	 */
	@Override
	public String toString() {
		return this.getFirstname();
	}

	/**
	 * getter for user name
	 * @return user login name
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * setter for user name
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getter for user password
	 * @return user login password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter for user password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * getter for user first name
	 * @return user first name
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * setter for user first name
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * getter for user last name
	 * @return user last name
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * setter for user last name
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * getter for user address
	 * @return user address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * setter for user address
	 */
	private void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * getter for user state
	 * @return user state
	 */
	public String getState() {
		return  this.state;
	}

	/**
	 * setter for user state
	 */
	private void setState(String state) {
		this.state = state;
	}
	
	/**
	 * getter for user zip code
	 * @return user zip code
	 */
	public String getZipCode() {
		return  this.zipCode;
	}

	/**
	 * setter for user zip code
	 */
	private void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * getter for user language preference
	 * @return user language preference
	 */
	public String getLanguage() {
		return  this.language;
	}

	/**
	 * setter for user language preference
	 */
	private void setLanguage(String language) {
		this.language = language;
	}
}
