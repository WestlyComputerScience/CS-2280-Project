package edu.iastate.cs2280.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author <<Westly Orr>>
 * @date 09/14/2024
 * 
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness 
{

	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
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

	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return the profit from a town grid
	 */
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

	/**
	 * Gets the total casual profit count from 12 months of billing cycle
	 * @param t: the town you wish to update the billing cycle of 12 months for
	 * @return the total casual profit (1$ per casual profit)
	 */
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
	/**
	 *  Main method. Calculates total profit over 12 month course based on file upload or 
	 *  manual input.
	 * 
	 * @param args : argument may be passed
	 * 
	 */
	public static void main(String []args) 
	{
		Scanner scnr = new Scanner(System.in);
		System.out.println("How to populate grid (type 1 or 2) : 1: from a file. 2: randomly with seed");
		int w = scnr.nextInt();
		if (w == 1)
		{
			System.out.println("Please enter file path:");
			//like ISP4x4.txt
			String s = "";
			while(s.equals(""))
			{
				s = scnr.nextLine();
			}
			try 
			{
				Town t = new Town(s);
				int totalProfit = 0;
				totalProfit = getCasProfitCount(t);
				//calculates profit percentage
				int length = t.getLength();
				int width = t.getWidth();
				double total = (((double)totalProfit) / ((double)length * width * 12));
				total = (total * 10000.0);
				total = (int)(total + 0.5);
				total = total/100.0;

				System.out.printf( "%.2f", total);
				System.out.print("%");

				scnr.close();
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("File not found");
			}
		}
		else if(w == 2)
		{
			int totalProfit = 0;
			System.out.println("Provide rows, cols and seed integer by space:");

			int i1 = scnr.nextInt();
			int i2 = scnr.nextInt();
			int i3 = scnr.nextInt();

			Town t = new Town(i1, i2);
			t.randomInit(i3);

			totalProfit = getCasProfitCount(t);
			//calculates profit percentage
			int length = t.getLength();
			int width = t.getWidth();
			double total = (((double)totalProfit) / ((double)length * width * 12));
			total = (total * 10000.0);
			total = (int)(total + 0.5);
			total = total/100.0;

			System.out.println();
			System.out.printf( "%.2f", total);
			System.out.print("%");
			scnr.close();
		}
	}
}