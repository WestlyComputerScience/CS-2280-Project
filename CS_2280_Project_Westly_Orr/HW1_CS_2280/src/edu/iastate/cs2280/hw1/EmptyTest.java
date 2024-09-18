package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmptyTest 
{
	/*
	 * This tests the next method in empty to check for correct output
	 */
	@Test
	void test() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(1,0);
		TownCell tc2 = tc.next(t);
		TownCell cas = new Casual(t, 1, 0);
		if(tc2.getClass() == cas.getClass())
		{
			System.out.println("Test 1 Empty: Passed");
		}
		else
		{
			fail("Test 1 Empty: Objects don't match");
		}
	}
	
	/*
	 * This tests the who method in empty for correct output
	 */
	@Test
	void test1()
	{
		Town t = new Town(4,4);
		t.randomInit(10);
		State e = t.getGrid(1, 0).who();
		State emp = State.EMPTY;
		if(e == emp)
		{
			System.out.println("Test 2 Empty: Passed");
		}
		else
		{
			System.out.println("Test 2 Empty: State's don't match");
		}
	}
	
	/*
	 * This tests the constructor
	 */
	@Test
	void test2()
	{
		Town t = new Town(4,4);
		t.randomInit(10);
		Empty e = new Empty(t, 0, 0);
		if(e.getClass() != null)
		{
			System.out.println("Test 3 Empty: Passed");
		}
		else
		{
			System.out.println("Test 3 Empty: object not created");
		}
	}
}
