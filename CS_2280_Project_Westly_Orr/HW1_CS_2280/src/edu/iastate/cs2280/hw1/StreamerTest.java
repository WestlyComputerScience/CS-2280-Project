package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StreamerTest 
{
	/*
	 * This tests the next method in streamer to check for correct output
	 */
	@Test
	void test() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(2,3);
		TownCell tc2 = tc.next(t);
		TownCell out = new Outage(t, 2, 3);
		if(tc2.getClass() == out.getClass())
		{
			System.out.println("Test 1 Streamer: Passed");
		}
		else
		{
			fail("Test 1 Streamer: Objects don't match");
		}
	}
	
	/*
	 * This tests the who method in streamer for correct output
	 */
	@Test
	void test1()
	{
		Town t = new Town(4,4);
		t.randomInit(10);
		State s = t.getGrid(2, 3).who();
		State str = State.STREAMER;
		if(s == str)
		{
			System.out.println("Test 2 Streamer: Passed");
		}
		else
		{
			System.out.println("Test 2 Streamer: State's don't match");
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
		Streamer s = new Streamer(t, 0, 0);
		if(s.getClass() != null)
		{
			System.out.println("Test 3 Streamer: Passed");
		}
		else
		{
			System.out.println("Test 3 Streamer: object not created");
		}
	}
}
