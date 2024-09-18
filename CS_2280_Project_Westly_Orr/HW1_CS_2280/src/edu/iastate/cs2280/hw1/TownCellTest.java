package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TownCellTest 
{
	/*
	 * This is used to test the census method
	 * It makes sure it outputs the correct census
	 */
	@Test
	void test() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(1,1);
		int[] ar = new int[5];
		tc.census(ar);
		// Fill array with
		// 1, 2, 1, 3, 1
		int[] check = new int[5];
		check[0] = 1;
		check[1] = 2;
		check[2] = 1;
		check[3] = 3;
		check[4] = 1;
		
		boolean b = true;
		for (int i = 0; i < 5; i++)
		{
			if(!(check[i] == ar[i]))
			{
				b = false;
			}
		}
		if (b)
		{
			System.out.println("Test 1 TownCell: Passed");
		}
		else
		{
			System.out.println("Test 1 TownCell: incorrect census was taken");
		}
	}
	
	/*
	 * This is used to test the getRow method
	 */
	@Test
	void test2() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(0, 0);
		int x = tc.getRow();
		
		if (x == 0)
		{
			System.out.println("Test 2 TownCell: Passed");
		}
		else
		{
			System.out.println("Test 2 TownCell: incorrect row was received");
		}
	}
	
	/*
	 * This is used to test the geCol method
	 */
	@Test
	void test3() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(0, 0);
		int x = tc.getCol();
		
		if (x == 0)
		{
			System.out.println("Test 3 TownCell: Passed");
		}
		else
		{
			System.out.println("Test 3 TownCell: incorrect col was received");
		}
	}
	
	/*
	 * This is used to test the censusStateCheckHelper method
	 */
	@Test
	void test4() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(0, 0);
		int x = tc.censusStateCheckHelper(0, 0);
		
		if (x == 3)
		{
			System.out.println("Test 4 TownCell: Passed");
		}
		else
		{
			System.out.println("Test 4 TownCell: incorrect state was checked");
		}
	}
	
	/*
	 * This is used to test the censusCheckHelper method
	 */
	@Test
	void test5() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(0, 0);
		int[] ar = new int[5];
		tc.censusCheckHelper(ar, 0, 0);
		int[] check = new int[5];
		check[0] = 1;
		check[3] = 1;
		
		boolean b = true;
		for (int i = 0; i < 5; i++)
		{
			if(!(check[i] == ar[i]))
			{
				b = false;
			}
		}
		if (b)
		{
			System.out.println("Test 5 TownCell: Passed");
		}
		else
		{
			System.out.println("Test 5 TownCell: incorrect census helper was taken");
		}

	}
}
