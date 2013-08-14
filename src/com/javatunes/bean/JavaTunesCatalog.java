/*
 * Java Tunes Catalog implementation provides methods to access java tunes music items
 */
package com.javatunes.bean;

import java.util.Collection;
import java.util.List;

// Implementation of Catalog interface using ItemDAO
public class JavaTunesCatalog implements Catalog {
	
	// DAO property to access database
   private ItemDAO dao;
   
   // max search results returns
   private int maxSearchResults = 0;
   
   /**
    * setter for max search results
    * @param maxIn
    */
   public void setMaxSearchResults(int maxIn) {
	   maxSearchResults = maxIn;
   }
   
   /**
    * getter for max search results
    * @return max search results
    */
   public int getMaxSearchResults() { return maxSearchResults; }

   /**
    * Constructor with music item DAO
    * @param daoIn
    */
	public JavaTunesCatalog(ItemDAO daoIn) {
		dao = daoIn;
	}
	
	/** Find music item from given music item id
	 * @param id
	 * @return @MusicItem entity
	 */
   public MusicItem findById(Long id) {
	   System.out.println("JavaTunesCatalog:findById = " + id);

      // delegate to the search bean
      return dao.get(id);
  }
   
   /**
    * Find the first 20 music items
    * @return a collection of first 20 music items delegating for DAO
    */
   public Collection<MusicItem> findFirstTwenty() {
	   return trim(dao.getAll());
   }

   /**
    * Find a collection of music item by given keyword: title+artist
    * @param keyword - music title or artist
    * @return collection of music searched
    */
   public Collection<MusicItem> findByKeyword(String keyword)  {
      System.out.println("JavaTunesCatalog:findByKeyword - " + keyword);

      // delegate to the search Bean, then trim the results
      return dao.searchByArtistTitle(keyword);
   }

   /**
    * Simple method to trim the results collection down to a size of maxSearchResults
    * @param results
    * @return collection of searched results with only numbers specified by max search results
    */
   private Collection<MusicItem> trim (Collection<MusicItem> results) {
	   Collection<MusicItem> ret = results;
	   if ( (maxSearchResults > 0) 
			&& (results.size() > maxSearchResults) 
			&& (results instanceof List) ) {
		   ret = ((List<MusicItem>)results).subList(0, maxSearchResults);
	   }
	   return ret;
   }
   
   /**
    * Constructor
    */
	public JavaTunesCatalog() {
	}
}