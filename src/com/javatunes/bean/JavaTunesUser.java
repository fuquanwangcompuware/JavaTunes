/*
 * Methods for accessing user information:
 * 	- check user's credential
 * 	- user registration
 * 	- search user by given username - primary key
 */

package com.javatunes.bean;

public class JavaTunesUser {

	// DAO for accessing user information in database
	private UserDAO dao;

	/**
	 * Constructor with DAO information
	 * @param daoIn
	 */
	public JavaTunesUser(UserDAO daoIn) {
		dao = daoIn;
	}
	
	/**
	 * Check user's credential with given username and password
	 * @param username
	 * @param password
	 * @return User entity if correct user name and password, null if incorrect
	 */
   public User findByUsernamePassword(String username, String password)  {
      System.out.println("JavaTunesUser:findByUsernamePassword - " + username + " " + password);

      // delegate to the search Bean, then trim the results
      User user = dao.findUserByUsername(username);
      
      // check username and password are the same, if yes return that @User entity
      if(user!=null && user.getPassword().equals(password)) {
    	  return user;
      }
      
      // Return null if user's credential is incorrect
      return null;
   }
   
   /**
    * User registration, persist user's information for a given user entity
    * @param user
    * @return user just added
    */
   public User addUser(User user){
	   return dao.addUser(user);
   }
   
   /**
    * Search user via username
    * @param username
    * @return User entity if found, null if not found
    */
   public User findUserByUsername(String username) {
	   return dao.findUserByUsername(username);
   }
}