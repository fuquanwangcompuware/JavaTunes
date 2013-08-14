/*
 * JPA Data Access Object implementation
 */

package com.javatunes.catalog.persist;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javatunes.bean.Cart;
import com.javatunes.bean.CartDAO;
import com.javatunes.bean.MusicItem;

public class JpaCartDAO implements CartDAO {

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
	 * search for single music item by id
	 * @param id
	 * @return single music item if found, null if not found
	 */
	public MusicItem get(Long id) {
		return em.find(MusicItem.class, id);
	}
	
	/**
	 * utility to print arrays
	 * @param array
	 */
	public void printArray(String[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}

	/**
	 * Transaction for saving cart
	 * @param shopping cart
	 * @return if the operation is successful
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean saveCart(Cart cart) {
		
		// new cart detail
		String newCartDetail = cart.getCartDetail();
		
		// current cart status
		Cart currentCart = em.find(Cart.class, cart.getUsername());

		// create one if not existing
		if (currentCart == null) {
			em.persist(new Cart(cart.getUsername(), newCartDetail.substring(1)));
			
		// merge the new cart to the current existing one 
		} else {
			String currentCartDetail = currentCart.getCartDetail();
			System.out.println("currentCartDetail " + currentCartDetail);
			System.out.println("newCartDetail " + newCartDetail);
			String[] currentCartArray = currentCartDetail.split(",");
			printArray(currentCartArray);
			
			// if this specific is found in the current cart detail
			boolean found = false;

			// loop over the current cart detail to see if found
			for (int i = 0; i < currentCartArray.length; i++) {
				
				// one item found
				String[] oneCart = currentCartArray[i].split(":");
				
				printArray(oneCart);
				
				// ID for this music item
				String itemID = oneCart[0];
				
				// quantity for this music item
				String quantity = oneCart[1];
				
				// ID for the music item to be merged
				String newItemID = newCartDetail.substring(1).split(":")[0];
				
				// quantity for the music item to be merged
				String newQuantity = newCartDetail.substring(1).split(":")[1];
				
				System.out.println(itemID);
				System.out.println(quantity);
				System.out.println(newCartDetail+ "->" + newCartDetail.substring(1) +"->"+ newItemID);
				System.out.println(newQuantity);
				
				// check if this music item is already in the cart
				if (oneCart.length == 2 && itemID.equals(newItemID)) {
					
					// add up the quantity
					int addedQuantity = Integer.parseInt(newQuantity) + Integer.parseInt(quantity);
					String itemToBereplaced = itemID + ":" + addedQuantity;
					
					System.out.println("repalcing " + currentCartArray[i] + " with " + itemToBereplaced + " in " + currentCartDetail);
					
					// merge this item with new quantity
					String newRepalcedCartDetail = currentCartDetail.replace(currentCartArray[i], itemToBereplaced);

					newCartDetail = newRepalcedCartDetail;
					found = true;
					
					// stop loop if found since one music item will only occur once in the cart
					break;
				}
			}
			
			// If not found then append to current cart
			if(!found) {
				newCartDetail = currentCartDetail + cart.getCartDetail();
			}

			// persist cart
			em.merge(new Cart(cart.getUsername(), newCartDetail));
		}

		return true;
	}

	/**
	 * get a user's shopping cart by given user's login name
	 * @param user login name
	 * @return user's shopping cart info
	 */
	@Override
	public Cart retrieveCart(String username) {
		return em.find(Cart.class, username);
	}

	/**
	 * Transaction for remove a cart
	 * @param cart entity to be removed
	 * @return if the operation is successful
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean removeCart(Cart cart) {
		try {
			em.remove(em.find(Cart.class, cart.getUsername()));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
