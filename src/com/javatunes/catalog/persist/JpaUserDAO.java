/*
 * JPA Data Access Object implementation
 */

package com.javatunes.catalog.persist;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javatunes.bean.User;
import com.javatunes.bean.UserDAO;

/**
 * 
 * @author amifxw0
 *
 */
public class JpaUserDAO implements UserDAO {

	// Entity Manager
	@PersistenceContext
	private EntityManager em;

	// getter for entity manager
	public EntityManager getEm() {
		return em;
	}

	// setter for entity manager
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * Search user by given user name
	 * @param user login name
	 * @return user entity if found, empty collection if not found
	 */
	@Override
	public User findUserByUsername(String username) {
		
		// format user name
		username = username.trim();

		// create query
		Query query = em.createQuery(
				"from User as u where u.username = :username", User.class);
		query.setParameter("username", username);

		Collection<User> userList = query.getResultList();
		System.out.println("=========validateUser===== size  " + userList.size());

		if (userList.size() > 0) {
			return (User) userList.toArray()[0];
		}

		return null;
	}

	/**
	 * Transaction for adding user
	 * @param user entity
	 * @return added user
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public User addUser(User user) {
		String username = user.getUsername().trim();
		String password = user.getPassword().trim();
		String firstname = user.getFirstname().trim();
		String lastname = user.getLastname().trim();
		String address = user.getAddress().trim();
		String state = user.getState().trim();
		String zipCode = user.getZipCode().trim();
		String language = user.getLanguage().trim();

		// If user does not exist, adding
		if (findUserByUsername(username) == null) {
			try {
				User formattedUser = new User(username, password, firstname, lastname, address, state, zipCode, language);
				em.persist(formattedUser);
				return user;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
}
