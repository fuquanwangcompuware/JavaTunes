/*
 * Tax support table
 * 
 * Contains 50 states + DC name and the tax rate 
 */

package com.javatunes.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Tax table for 50 states and DC
 * @author amifxw0
 *
 */
public class TaxTable {
	
	// tax table
	static final Map<String, Float> taxTable = new HashMap<String, Float>();
	
	// init the tax data for each state
	static {
		taxTable.put("Alabama", 0.04f);
		taxTable.put("Alaska",  0.0f);
		taxTable.put("Arizona", 0.056f);
		taxTable.put("Arkansas", 0.06f);
		taxTable.put("California", 0.075f);
		
		taxTable.put("Colorado", 0.029f);
		taxTable.put("Connecticut", 0.0635f);
		taxTable.put("Delaware", 0.0f);
		taxTable.put("District of Columbia", 0.06f);
		taxTable.put("Florida", 0.06f);
		taxTable.put("Georgia", 0.04f);
		
		taxTable.put("Hawaii", 0.04f);
		taxTable.put("Idaho", 0.06f);
		taxTable.put("Illinois", 0.0625f);
		taxTable.put("Indiana", 0.07f);
		taxTable.put("Iowa", 0.06f);
		
		taxTable.put("Kansas", 0.063f);
		taxTable.put("Kentucky", 0.06f);
		taxTable.put("Louisiana", 0.04f);
		taxTable.put("Maine", 0.05f);
		taxTable.put("Maryland", 0.06f);
		
		taxTable.put("Massachusetts", 0.0625f);
		taxTable.put("Michigan", 0.06f);
		taxTable.put("Minnesota", 0.06875f);
		taxTable.put("Mississippi", 0.07f);
		taxTable.put("Missouri", 0.04225f);
		
		taxTable.put("Montana", 0.00f);
		taxTable.put("Nebraska", 0.055f);
		taxTable.put("Nevada", 0.0685f);
		taxTable.put("New Hampshire", 0.00f);
		taxTable.put("New Jersey", 0.07f);
		
		taxTable.put("New Mexico", 0.05125f);
		taxTable.put("New York", 0.04f);
		taxTable.put("North Carolina", 0.0475f);
		taxTable.put("North Dakota", 0.05f);
		taxTable.put("Ohio", 0.055f);
		
		taxTable.put("Oklahoma", 0.045f);
		taxTable.put("Oregon", 0.00f);
		taxTable.put("Pennsylvania", 0.06f);
		taxTable.put("Rhode Island", 0.07f);
		taxTable.put("South Carolina", 0.06f);
		
		taxTable.put("South Dakota", 0.04f);
		taxTable.put("Tennessee", 0.07f);
		taxTable.put("Texas", 0.0625f);
		taxTable.put("Utah", 0.047f);
		taxTable.put("Vermont", 0.06f);
		
		taxTable.put("Virginia", 0.04f);
		taxTable.put("Washington", 0.065f);
		taxTable.put("West Virginia", 0.06f);
		taxTable.put("Wisconsin", 0.05f);
		taxTable.put("Wyoming", 0.04f);
	}
	
	/**
	 * query tax rate for a given state
	 * @param state
	 * @return
	 */
	public static float getTaxRate(String state) {
		float taxRate = 0.0f;
		if(taxTable.get(state)!=null) {
			taxRate = taxTable.get(state);
		}
		return taxRate;
	}
}
