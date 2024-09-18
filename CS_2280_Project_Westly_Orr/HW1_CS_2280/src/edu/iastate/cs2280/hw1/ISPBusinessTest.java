package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.iastate.cs2280.hw1.ISPBusiness;

import org.junit.jupiter.api.Test;

class ISPBusinessTest 
{
	public static Town updatePlain(Town tOld) 
	{
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		for (int r = 0; r < tOld.getLength(); r++)
		{
			for (int c = 0; c < tOld.getWidth(); c++)
			{
				TownCell tc = tOld.getGrid(r,c).next(tNew);
				tNew.setGrid(tc, r, c);
			}
		}
		return tNew;
	}

	/*
	 * This tests if updatePlain method updates correctly
	 */
	@Test
	void test() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		Town t1 = updatePlain(t);
		String check = t1.toString();
		String check1 = "E E E E \nC C O E \nC O E O \nC E E E \n";
		if(check.equals(check1))
		{
			System.out.println("Test 1 ISPBusiness: Passed");
		}
		else
		{
			System.out.println("Test 1 ISPBusiness: plain updated incorrectly");
		}
	}

	public static int getProfit(Town town) 
	{
		int sumOfCas = 0;
		for (int r = 0; r < town.getLength(); r++)
		{
			for (int c = 0; c < town.getWidth(); c++)
			{
				TownCell tc = town.getGrid(r,  c);
				State cas = State.CASUAL;
				if (tc.who() == cas)
				{
					sumOfCas++;
				}
			}
		}
		return sumOfCas;
	}

	/*
	 * This tests if getProfit method works correctly
	 */
	@Test
	void test1() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		int x = getProfit(t);

		if(x == 1)
		{
			System.out.println("Test 2 ISPBusiness: Passed");
		}
		else
		{
			System.out.println("Test 2 ISPBusiness: profit incorrectly counted");
		}
	}

	public static int getCasProfitCount(Town t)
	{
		int totalProfit = 0;
		totalProfit = totalProfit + getProfit(t);

		Town t1 = updatePlain(t);
		//System.out.println(t1.toString());
		totalProfit = totalProfit + getProfit(t1);

		Town t2 = updatePlain(t1);
		//System.out.println(t2.toString());
		totalProfit = totalProfit + getProfit(t2);

		Town t3 = updatePlain(t2);
		//System.out.println(t3.toString());
		totalProfit = totalProfit + getProfit(t3);

		Town t4 = updatePlain(t3);
		//System.out.println(t4.toString());
		totalProfit = totalProfit + getProfit(t4);

		Town t5 = updatePlain(t4);
		//System.out.println(t5.toString());
		totalProfit = totalProfit + getProfit(t5);

		Town t6 = updatePlain(t5);
		//System.out.println(t6.toString());
		totalProfit = totalProfit + getProfit(t6);

		Town t7 = updatePlain(t6);
		//System.out.println(t7.toString());
		totalProfit = totalProfit + getProfit(t7);

		Town t8 = updatePlain(t7);
		//System.out.println(t8.toString());
		totalProfit = totalProfit + getProfit(t8);

		Town t9 = updatePlain(t8);
		//System.out.println(t9.toString());
		totalProfit = totalProfit + getProfit(t9);

		Town t10 = updatePlain(t9);
		//System.out.println(t10.toString());
		totalProfit = totalProfit + getProfit(t10);

		Town t11 = updatePlain(t10);
		//System.out.println(t11.toString());
		totalProfit = totalProfit + getProfit(t11);

		return totalProfit;
	}

	/*
	 * Checks if getCasProfitCount works correctly
	 */
	@Test
	void test2() 
	{
		Town t = new Town(4, 4);
		t.randomInit(10);
		int x = getCasProfitCount(t);

		if(x == 53)
		{
			System.out.println("Test 3 ISPBusiness: Passed");
		}
		else
		{
			System.out.println("Test 3 ISPBusiness: profit incorrectly counted over 12 month span");
		}
	}

	/*
	 * Tests if correct profit is calculated from 4x4 grid
	 */
	@Test
	void test3()
	{
		try 
		{
			Scanner scnr = new Scanner(System.in);
			Town t = new Town("ISP4x4.txt");
			int totalProfit = 0;
			totalProfit = getCasProfitCount(t);
			//calculates profit percentage
			int length = t.getLength();
			int width = t.getWidth();
			double total = (((double)totalProfit) / ((double)length * width * 12));
			total = (total * 10000.0);
			total = (int)(total + 0.5);
			total = total/100.0;
			if(total == 27.60)
			{
				System.out.println("Test 4 ISPBusiness: Passed");
			}
			else
			{
				System.out.println("Test 4 ISPBusiness: profit incorrectly calculated over 12 month span");
			}
			scnr.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
	}
	
	/*
	 * Tests if correct profit is calculated from 4x3 grid
	 */
	@Test
	void test4()
	{
		try 
		{
			Scanner scnr = new Scanner(System.in);
			Town t = new Town("ISP4x3.txt");
			int totalProfit = 0;
			totalProfit = getCasProfitCount(t);
			//calculates profit percentage
			int length = t.getLength();
			int width = t.getWidth();
			double total = (((double)totalProfit) / ((double)length * width * 12));
			total = (total * 10000.0);
			total = (int)(total + 0.5);
			total = total/100.0;
			if(total == 33.33)
			{
				System.out.println("Test 5 ISPBusiness: Passed");
			}
			else
			{
				System.out.println("Test 5 ISPBusiness: profit incorrectly calculated over 12 month span");
			}
			scnr.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
	}
	
	/*
	 * Tests if correct profit is calculated from 6x8 grid with user input
	 */
	@Test
	void test5()
	{

		Town t = new Town(6, 8);
		t.randomInit(12);
		int totalProfit = 0;
		totalProfit = getCasProfitCount(t);
		//calculates profit percentage
		int length = t.getLength();
		int width = t.getWidth();
		double total = (((double)totalProfit) / ((double)length * width * 12));
		total = (total * 10000.0);
		total = (int)(total + 0.5);
		total = total/100.0;
		if(total == 33.68)
		{
			System.out.println("Test 6 ISPBusiness: Passed");
		}
		else
		{
			System.out.println("Test 6 ISPBusiness: profit incorrectly calculated over 12 month span");
		}
	}
}
