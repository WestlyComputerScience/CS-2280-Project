package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TownTest 
{
	/*
	 * This test is used to test the constructor, and to make sure a town grid can be created
	 * from a person inputing width, length, and seed.
	 */
	@Test
	void test() 
	{
		//These are predetermined values that a person enters to test this method.
		//They'll enter 4 for length and width, and 10 for the seed.
		int len = 4;
		int wid = 4;
		int seed = 10;
		Town t = new Town(len, wid);
		t.randomInit(seed);
		String s = t.toString();
		String s1 = "O R O R \nE E C O \nE S O S \nE O R R \n";
		if(s.equals(s1))
		{
			System.out.println("Test 1 Town: Passed");
		}
		else
		{
			System.out.println("Test 1 Town: Grid incorrectly generated");
		}
	}

	/*
	 * Tests if getGrid works
	 */
	@Test
	void test2() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.getGrid(0,0);
		TownCell out = new Outage(t, 0, 1);
		if(tc.getClass() == out.getClass())
		{
			System.out.println("Test 2 Town: Passed");
		}
		else
		{
			System.out.println("Test 2 Town: value received was incorrect");
		}
	}
	/*
	 * Tests if setGrid works
	 */
	@Test
	void test3() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = new Casual(t, 0, 0);
		t.setGrid(tc,0,0);
		TownCell cas = new Casual(t, 0, 1);
		if(tc.getClass() == cas.getClass())
		{
			System.out.println("Test 3 Town: Passed");
		}
		else
		{
			System.out.println("Test 3 Town: value set incorrectly");
		}
	}
	/*
	 * Tests if inputing a file 4x4 grid works
	 */
	@Test
	void test4() 
	{
		try 
		{
			String s = "ISP4x4.txt";
			Town t = new Town(s);
			
			Town t1 = new Town(4,4);
			t1.randomInit(10);
			
			String check = t.toString();
			String check1 = t1.toString();
			if(check.equals(check1))
			{
				System.out.println("Test 4 Town: Passed");
			}
			else
			{
				System.out.println("Test 4 Town: grid generated incorrectly");
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
	}
	
	/*
	 * Tests if inputing a file 4x3 grid works.
	 * Tested this for the substring method
	 */
	@Test
	void test5() 
	{
		try 
		{
			String s = "ISP4x3.txt";
			Town t = new Town(s);
			
			String check1 = "O R O \nE E C \nE S O \nE O R \n";
			
			String check = t.toString();
			
			if(check.equals(check1))
			{
				System.out.println("Test 5 Town: Passed");
			}
			else
			{
				System.out.println("Test 5 Town: grid generated incorrectly");
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
	}
	
	/*
	 * Tests if convertCharacterToCell works
	 */
	@Test
	void test6() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		TownCell tc = t.convertCharacterToCell(t, "R", 0, 0);
		TownCell res = new Reseller(t, 0, 0);
		if(tc.getClass() == res.getClass())
		{
			System.out.println("Test 6 Town: Passed");
		}
		else
		{
			System.out.println("Test 6 Town: incorrectly converted character");
		}
	}
	
	/*
	 * Tests if getWidth works
	 */
	@Test
	void test7() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		int x = t.getWidth();
		if (x == 4)
		{
			System.out.println("Test 7 Town: Passed");
		}
		else
		{
			System.out.println("Test 7 Town: incorrect width");
		}
	}
	
	/*
	 * Tests if getLength works
	 */
	@Test
	void test8() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		int x = t.getLength();
		if (x == 4)
		{
			System.out.println("Test 8 Town: Passed");
		}
		else
		{
			System.out.println("Test 8 Town: incorrect length");
		}
	}
	
	/*
	 * Tests if setWidth works
	 */
	@Test
	void test9() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		t.setWidth(5);
		int x = t.getWidth();
		if (x == 5)
		{
			System.out.println("Test 9 Town: Passed");
		}
		else
		{
			System.out.println("Test 9 Town: incorrect width");
		}
	}
	
	/*
	 * Tests if setLength works
	 */
	@Test
	void test10() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		t.setLength(5);
		int x = t.getLength();
		if (x == 5)
		{
			System.out.println("Test 10 Town: Passed");
		}
		else
		{
			System.out.println("Test 10 Town: incorrect length");
		}
	}
	
	/*
	 * Tests if randomInit works
	 */
	@Test
	void test11() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		String check = t.toString();
		String check1 = "O R O R \nE E C O \nE S O S \nE O R R \n";
		if (check.equals(check1))
		{
			System.out.println("Test 11 Town: Passed");
		}
		else
		{
			System.out.println("Test 11 Town: incorrectly generated grid");
		}
	}
	
	/*
	 * Tests if toString works
	 */
	@Test
	void test12() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		String check = t.toString();
		String check1 = "O R O R \nE E C O \nE S O S \nE O R R \n";
		if (check.equals(check1))
		{
			System.out.println("Test 12 Town: Passed");
		}
		else
		{
			System.out.println("Test 12 Town: incorrect string");
		}
	}
}
