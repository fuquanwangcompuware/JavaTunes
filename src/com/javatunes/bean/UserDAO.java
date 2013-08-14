/*
 * Data Access Object interface for Java Tunes user, provides:
 * 	- get single user by user name
 * 	- add user for registration
 */

package com.javatunes.bean;

public interface UserDAO {
	public User findUserByUsername(String username);
	public User addUser(User user);
}