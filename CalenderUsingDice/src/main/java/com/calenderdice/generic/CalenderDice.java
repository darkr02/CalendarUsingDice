/**
 * 
 */
package com.calenderdice.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author admin
 *
 */
public class CalenderDice 
{

	public static final Integer[] mandatoryItems={0,1,2};
	public static final Integer[] otherItems = {3,4,5,6,7,8,9};

	//Verify the two dices are proper to complete the days of the month
	public static boolean verifyDicesAreProper(Integer[] dice1, Integer[] dice2)
	{
		//Use the method of elimination to check the two dices are proper
		//eleminate the mandatories first
		Integer[] dice1WoM = eleminateItems(dice1, mandatoryItems);
		Integer[] dice2WoM = eleminateItems(dice2, mandatoryItems);
		Integer[] diceMerged = mergeTwoArray(dice1WoM,dice2WoM);
		//Eliminate all the other items also from the array to see either 6 or 9 should be present
		Integer[] diceElAll = eleminateItems(diceMerged, otherItems);
		if ((diceElAll.length == 1) && (diceElAll[0]==6 ||diceElAll[0]==9))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	//Merging of two arrays
	private static Integer[] mergeTwoArray(Integer[] dice1, Integer[] dice2)
	{
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(dice1));
		list.addAll(Arrays.asList(dice2));
		Integer[] c = list.toArray(new Integer[list.size()]);
		
		return c;
	}
	//Eliminate mandatories from dice array
	private static Integer[] eleminateItems(Integer[] dice, Integer[] mandatoryItems)
	{
		List<Integer> lst = new ArrayList<Integer>();
		lst.addAll(Arrays.asList(dice));
		lst.addAll(Arrays.asList(mandatoryItems));
		Collections.sort(lst);
		Object[] arr = (Object[])lst.toArray();
		for ( Object item : arr)
		{
			if (lst.indexOf(item) != lst.lastIndexOf(item)) 
			{
	            lst.remove(lst.lastIndexOf(item));
	            lst.remove(lst.indexOf(item));
	        }
		}
		Integer[] arr1 = lst.toArray(new Integer[lst.size()]);
		
		
		return arr1;
	}
	
	//Verify whether a dice has a duplicate numbers or not 
	public static boolean verifyDuplicates(Integer[] dice)
	{
		for (int i = 0; i < dice.length; i++) 
		{
			for (int j = i + 1 ; j < dice.length; j++) 
			{
				if (dice[i].equals(dice[j])) 
				{
					// got the duplicate element
					return false;
				}
			}
		}
		return true;
	}

	//Check whether mandatory values are there
	public static boolean verifyMandatoryValues(Integer[] dice, Integer[] mandatoryItems)
	{
		int n=0;
		for (int i = 0; i < mandatoryItems.length; i++) 
		{
			for (int j = 0; j < dice.length; j++) 
			{
				if (dice[i].equals(dice[j])) 
				{
					n=n+1;
					break;
				}
			}
		}
		if (n==3)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}
