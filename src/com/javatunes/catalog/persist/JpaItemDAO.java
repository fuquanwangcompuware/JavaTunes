/*
 * JPA Data Access Object implementation
 */


package com.javatunes.catalog.persist;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.javatunes.bean.ItemDAO;
import com.javatunes.bean.MusicItem;

/**
 * 
 * @author amifxw0
 *
 */
public class JpaItemDAO implements ItemDAO {
	
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
	 * Search a music item by given id
	 * @param music id
	 * @return music item if found, null if not found
	 */
	public MusicItem get(Long id) {
		return em.find(MusicItem.class, id);
	}

	/**
	 * get all the current music items
	 * @return collection of all music items
	 */
	@Override
	public Collection<MusicItem> getAll() {
		Collection<MusicItem> collection = new ArrayList<MusicItem>();
		collection = em.createQuery("from MusicItem", MusicItem.class).getResultList();
		System.out.println("=============getAll=============== size  " + collection.size());
		return collection;
	}

	/**
	 * search music item by given keyword
	 * searching will happens in title+artist
	 * 
	 * @param search keyword
	 * @return collection of search results
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<MusicItem> searchByArtistTitle(String keyword) {
		
		// format the keyword
		keyword = keyword.trim();
		
		// return all the itmes if no keyword
		if(keyword==null || keyword.length()==0) {
			return getAll();
		}
		
		// search in title and artist
		Query query = em.createQuery("from MusicItem as mi where mi.title like :title or mi.artist like :artist", MusicItem.class);
		query.setParameter("title", "%" + keyword + "%");
		query.setParameter("artist", "%" + keyword + "%");
		
		Collection<MusicItem> collection = query.getResultList();
		System.out.println("=========searchByArtistTitle===== size  " + collection.size());
		return collection;
	}
}
