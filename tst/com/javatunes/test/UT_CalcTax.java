/*
 * Unit test for total price calculation after tax for tax & tax-free states
 */

package com.javatunes.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.controller.Util;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfiguration.class })
/**
 * 
 * @author amifxw0
 * 
 ********************************************
 * 
 * User's shopping cart:
 *
 * item#1: $13.99 * 1 = $13.99
 * item#2: $14.99 * 2 = $29.98
 * item#3: $14.99 * 3 = $44.97
 * -----------------------------------------
 * Price before tax                   $88.94
 * 
 * 
 * user' State           - Alabama
 * user's state tax rate - 4%
 * 
 *                             $88.94 * 0.04
 * -----------------------------------------
 * Tax                                 $3.56
 * 
 * 
 *                            $88.94 + $3.56
 * =========================================
 * 
 * Total Price after Tax              $92.50
 * 
 * *****************************************
 */

public class UT_CalcTax {

	/**
	 * Test on AL which is a non-tax free state
	 */
	@Test
	public void testALTaxCalculation() {

		// Calculate total price after tax for Alabama
		float totalPriceAL = Util.calculatePriceAfterTax("Alabama", 88.94f);
 
		// total price should be 92.50
		assertTrue("Total price after tax should be 92.50", totalPriceAL == 92.50f);
	}

	/**
	 * Test on DE which is a tax free state
	 */
	@Test
	public void testDETaxCalculation() {
		// Calculate total price after tax for Tax Free state - DE
		float totalPriceDE = Util.calculatePriceAfterTax("Delaware", 88.94f);

		// total price should be 88.94
		assertTrue("Total price after tax should be 88.94", totalPriceDE == 88.94f);
	}
}