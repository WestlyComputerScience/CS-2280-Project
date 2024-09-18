package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutageTest 
{
	/*
	 * This tests the next outage in empty to check for correct output
	 */
	@Test
	void test() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(0,0);
		TownCell tc2 = tc.next(t);
		TownCell emp = new Empty(t, 0, 0);
		if(tc2.getClass() == emp.getClass())
		{
			System.out.println("Test 1 Outage: Passed");
		}
		else
		{
			fail("Test 1 Outage: Objects don't match");
		}
	}

	/*
	 * This tests the who method in outage for correct output
	 */
	@Test
	void test1()
	{
		Town t = new Town(4,4);
		t.randomInit(10);
		State o = t.getGrid(0, 0).who();
		State out = State.OUTAGE;
		if(o == out)
		{
			System.out.println("Test 2 Outage: Passed");
		}
		else
		{
			System.out.println("Test 2 Outage: State's don't match");
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
		Outage o = new Outage(t, 0, 0);
		if(o.getClass() != null)
		{
			System.out.println("Test 3 Outage: Passed");
		}
		else
		{
			System.out.println("Test 3 Outage: object not created");
		}
	}
}
