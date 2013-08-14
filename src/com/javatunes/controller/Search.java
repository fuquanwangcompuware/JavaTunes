/*
 * Data Model for search includes search keyword and search results
 */
 
package com.javatunes.controller;

import java.util.Collection;

import com.javatunes.bean.MusicItem;

/**
 * 
 * @author amifxw0
 *
 */
public class Search {
	
	// Search keyword
	private String keyword;
	
	// Search results
	private Collection<MusicItem> results;
	
	
	// getter for search keyword
	public String getKeyword() {
		return keyword;
	}
	
	// setter for search keyword
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	// getter for search results
	public Collection<MusicItem> getResults() {
		return results;
	}
	
	// setter for search results
	public void setResults(Collection<MusicItem> results) {
		this.results = results;
	}
}
