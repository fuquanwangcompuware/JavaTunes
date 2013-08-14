/*
 * Search controller for user to search on music items
 */

package com.javatunes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatunes.bean.Catalog;

/**
 * 
 * @author amifxw0
 *
 */
@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	Catalog cat;

	/**
	 * Handle HTTP GET reqest to direct to search form
	 * @param search
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("search") Search search) {
		return "searchForm";
	}

	/**
	 * Handl HTTP POST request to search music items based on search keyword and return results
	 * @param search
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("search") Search search) {
		System.out.println("SearchController.processSearch()");
		
		// Retrieve search keyword
		String searchFor = search.getKeyword();
		
		// search & set results
		search.setResults(cat.findByKeyword(searchFor));
		
		// return to search results view
		return "searchResults";
	}
}