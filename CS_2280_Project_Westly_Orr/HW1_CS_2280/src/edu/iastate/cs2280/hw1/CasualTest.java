package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class CasualTest 
{
	/*
	 * This tests the next method in casual to check for correct output
	 */
	@Test
	void test() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(1,2);
		TownCell tc2 = tc.next(t);
		TownCell out = new Outage(t, 1, 2);
		if(tc2.getClass() == out.getClass())
		{
			System.out.println("Test 1 Casual: Passed");
		}
		else
		{
			fail("Test 1 Casual: Objects don't match");
		}
	}
	
	/*
	 * This tests the who method in casual for correct output
	 */
	@Test
	void test1()
	{
		Town t = new Town(4,4);
		t.randomInit(10);
		State c = t.getGrid(1, 2).who();
		State cas = State.CASUAL;
		if(c == cas)
		{
			System.out.println("Test 2 Casual: Passed");
		}
		else
		{
			System.out.println("Test 2 Casual: State's don't match");
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
		Casual c = new Casual(t, 0, 0);
		if(c.getClass() != null)
		{
			System.out.println("Test 3 Casual: Passed");
		}
		else
		{
			System.out.println("Test 3 Casual: object not created");
		}
	}
}
