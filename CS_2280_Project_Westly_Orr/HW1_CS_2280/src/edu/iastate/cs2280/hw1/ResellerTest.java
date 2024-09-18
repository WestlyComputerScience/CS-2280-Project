package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResellerTest 
{
	/*
	 * This tests the next method in reseller to check for correct output
	 */
	@Test
	void test() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(0,1);
		TownCell tc2 = tc.next(t);
		TownCell emp = new Empty(t, 0, 1);
		if(tc2.getClass() == emp.getClass())
		{
			System.out.println("Test 1 Reseller: Passed");
		}
		else
		{
			fail("Test 1 Reseller: Objects don't match");
		}
	}
	
	/*
	 * This tests the who method in reseller for correct output
	 */
	@Test
	void test1()
	{
		Town t = new Town(4,4);
		t.randomInit(10);
		State r = t.getGrid(0, 1).who();
		State res = State.RESELLER;
		if(r == res)
		{
			System.out.println("Test 2 Reseller: Passed");
		}
		else
		{
			System.out.println("Test 2 Reseller: State's don't match");
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
		Reseller r = new Reseller(t, 0, 0);
		if(r.getClass() != null)
		{
			System.out.println("Test 3 Reseller: Passed");
		}
		else
		{
			System.out.println("Test 3 Reseller: object not created");
		}
	}
}
