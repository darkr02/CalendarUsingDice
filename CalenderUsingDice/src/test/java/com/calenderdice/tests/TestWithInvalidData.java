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
 *This test will deal with negative scenarios where Dice1 is having duplicates
 *
 */
public class TestWithInvalidData 
{
	Integer[] dice1 = {0,1,2,3,4,2};
	Integer[] dice2 = {0,1,2,6,7,8};

	@Test(priority=4)
	public void checkDuplicateValues1()
	{
		//This test case verifies whether dices are coming without duplicates values
		boolean bDuplicateDice1 = CalenderDice.verifyDuplicates(dice1);
		boolean bDuplicateDice2 = CalenderDice.verifyDuplicates(dice2);
		if (bDuplicateDice1 && bDuplicateDice2)
		{
			System.out.println("Test case is passed. No Duplicate values are present for both of the dices");
		}
		else if(bDuplicateDice1)
		{
			Assert.fail("Test case is Failed. Dice 1 is not having duplicates but the Dice2 has duplicates");
		}
		else if(bDuplicateDice2)
		{
			Assert.fail("Test case is Failed. Dice 2 is not having duplicates but the Dice1 has duplicates");
		}
		else 
		{
			Assert.fail("Test case is Failed. Duplicates are there for both of the dices");
		}

	}
	@Test(priority=5)
	public void checkMandatoryValues1()
	{
		//This test case verifies whether dices are coming with all the mandatory values
		boolean bMandatoryValueDice1 = CalenderDice.verifyMandatoryValues(dice1, CalenderDice.mandatoryItems);
		boolean bMandatoryValueDice2 = CalenderDice.verifyMandatoryValues(dice2, CalenderDice.mandatoryItems);
		if (bMandatoryValueDice1 && bMandatoryValueDice2)
		{
			System.out.println("Test case is passed. Mandatory value are present for both of the dices");
		}
		else if(bMandatoryValueDice1)
		{
			Assert.fail("Test case is Failed. Mandatory value is correct for the first dice only not the 2nd one");
		}
		else if(bMandatoryValueDice2)
		{
			Assert.fail("Test case is Failed. Mandatory value is correct for the second dice only not the 1st one");
		}
		else 
		{
			Assert.fail("Test case is Failed. Mandatory value is incorrect for the both of the dices");
		}

	}
	@Test(priority=6,dependsOnMethods={"checkMandatoryValues1"})
	public void checkDicesAreProper1()
	{
		//verify the set of two dices are proper to form date for a calendar
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
