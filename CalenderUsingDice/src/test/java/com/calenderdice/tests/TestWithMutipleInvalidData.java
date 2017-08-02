/**
 * 
 */
package com.calenderdice.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.calenderdice.generic.CalenderDice;

/**
 * @author Krishnendu Daripa
 *
 *This test will deal with negative scenarios.Verify the set of two dices are proper to form date for a calender using different set of data
 *
 */
public class TestWithMutipleInvalidData 
{

	@Test(priority=7)
	public void checkDicesAreProper2()
	{
		//verify the set of two dices are proper to form date for a calendar using different set of data
		Integer[] dice1 = {0,1,2,3,4,5};
		Integer[] dice2 = {0,1,2,6,7,9};
		boolean bProperDice = CalenderDice.verifyDicesAreProper(dice1,dice2);
		if (bProperDice)
		{
			System.out.println("Test case is passed. This set of two dices are proper to form any date of a month in a calender");
		}
		else
		{
			Assert.fail("Test case is Failed. This set of two dices cannot form all the dates of a month in a calender");
		}

	}
	@Test(priority=8)
	public void checkDicesAreProper3()
	{
		//verify the set of two dices are proper to form date for a calendar using different set of data
		Integer[] dice1 = {0,6,9,3,4,5};
		Integer[] dice2 = {0,1,2,6,7,8};
		boolean bProperDice = CalenderDice.verifyDicesAreProper(dice1,dice2);
		if (bProperDice)
		{
			System.out.println("Test case is passed. This set of two dices are proper to form any date of a month in a calender");
		}
		else
		{
			Assert.fail("Test case is Failed. This set of two dices cannot form all the dates of a month in a calender");
		}

	}
	@Test(priority=9)
	public void checkDicesAreProper4()
	{
		
		//verify the set of two dices are proper to form date for a calendar using different 
		Integer[] dice1 = {0,1,5,3,4,9};
		Integer[] dice2 = {0,1,2,6,7,8};
		boolean bProperDice = CalenderDice.verifyDicesAreProper(dice1,dice2);
		if (bProperDice)
		{
			System.out.println("Test case is passed. This set of two dices are proper to form any date of a month in a calender");
		}
		else
		{
			Assert.fail("Test case is Failed. This set of two dices cannot form all the dates of a month in a calender");
		}

	}

}
