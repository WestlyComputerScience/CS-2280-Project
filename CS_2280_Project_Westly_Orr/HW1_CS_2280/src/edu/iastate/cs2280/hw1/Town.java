package edu.iastate.cs2280.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


/**
 *  @author <<Westly Orr>>
 *  @date 09/14/2024
 *  
 * The Town class is what the neighborhood looks like. It can be used to create, get, and set grid cells
 * for the neighborhood.
 *
 */
public class Town 
{

	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;   //the 2D array for the neighborhood

	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];
	}

	/**
	 * Used to return grid values from the town
	 * @param r: asks for which row in grid
	 * @param c: asks for which col in grid
	 */
	public TownCell getGrid(int r, int c)
	{
		return grid[r][c];
	}

	public void setGrid(TownCell tc, int r, int c)
	{
		grid[r][c] = tc;
	}

	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException 
	{
		File f = new File(inputFileName);
		try 
		{
			int x = 0;
			int y = 0;
			Scanner fileScan = new Scanner(f);
			while(fileScan.hasNextInt())
			{
				x = fileScan.nextInt();
				y = fileScan.nextInt();
			}

			this.setLength(x);
			this.setWidth(y);
			grid = new TownCell[length][width];
			String s1 = "";
			String line = fileScan.nextLine();
			System.out.println();

			for(int r = 0; r < this.getLength(); r++)
			{
				//scans for line in file and gets rid of spaces for string
				line = fileScan.nextLine();
				String line1 = "";
				for(int i = 0; i < line.length(); i = i + 2)
				{
					line1 = line1 + line.substring(i,i+1);
				}
				line = line1;
				//i used to track substring
				int i = 0;
				for(int c = 0; c < this.getWidth(); c++)
				{
					s1 = line.substring(i, i+1);

					TownCell tc = convertCharacterToCell(this, s1, r, c);
					this.setGrid(tc, r, c);

					i++;
				}
				s1 = "";
			}
			fileScan.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
		}
	}

	/**
	 * Returns a TownCell object based on a string character.
	 * @param town: which town to use
	 * @param s1: enter the character for it to read(must be one of the TownCell subclasses)
	 * @param r: which row the object shall be created for
	 * @param c: which col the object shall be created for
	 * @return the new TownCell object
	 */
	public static TownCell convertCharacterToCell(Town t, String s1, int r, int c)
	{
		TownCell tc;
		if(s1.equals("R"))
		{
			tc = new Reseller(t, r, c);
			return tc;
		}
		else if(s1.equals("E"))
		{
			tc = new Empty(t, r, c);
			return tc;
		}
		else if(s1.equals("C"))
		{
			tc = new Casual(t, r, c);
			return tc;
		}
		else if(s1.equals("O"))
		{
			tc = new Outage(t, r, c);
			return tc;
		}
		else if(s1.equals("S"))
		{
			tc = new Streamer(t, r, c);
			return tc;
		}
		//will never run this statement
		else
		{
			return tc = null;
		}
	}

	/**
	 * Returns width of the grid.
	 * @return width of grid
	 */
	public int getWidth() 
	{
		return width;
	}

	/**
	 * Returns length of the grid.
	 * @return length of grid
	 */
	public int getLength() 
	{
		return length;
	}

	/**
	 * Sets the width of the grid
	 */
	public void setWidth(int w) 
	{
		width = w;
	}

	/**
	 * Sets the length of the grid
	 */
	public void setLength(int l) 
	{
		length = l;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 * 
	 * @param seed : inputs seed to generate numbers
	 * @return nothing
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);

		for(int r = 0; r < length; r++)
		{
			for(int c = 0; c < width; c++)
			{
				int x = rand.nextInt(5);

				if(x == 0)
				{
					Reseller res = new Reseller(this, r, c);
					grid[r][c] = res;
				}
				if(x == 1)
				{
					Empty emp = new Empty(this, r, c);
					grid[r][c] = emp;
				}
				if(x == 2)
				{
					Casual cas = new Casual(this, r, c);
					grid[r][c] = cas;
				}
				if(x == 3)
				{
					Outage out = new Outage(this, r, c);
					grid[r][c] = out;
				}
				if(x == 4)
				{
					Streamer st = new Streamer(this,r,c);
					grid[r][c] = st;
				}
			}
		}
	}

	/**
	 * Output the town grid in string format.
	 */
	@Override
	public String toString() 
	{
		String s = "";
		for (int r = 0; r < length; r++)
		{
			for (int c = 0; c < width; c++)
			{
				State z = grid[r][c].who();

				State cas = State.CASUAL;
				State res = State.RESELLER;
				State out = State.OUTAGE;
				State emp = State.EMPTY;
				State st = State.STREAMER;

				if (z == cas)
				{
					s = s + "C ";
				}
				if (z == res)
				{
					s = s + "R ";
				}
				if (z == out)
				{
					s = s + "O ";
				}
				if (z == emp)
				{
					s = s + "E ";
				}
				if (z == st)
				{
					s = s + "S ";
				}
			}
			s = s + "\n";
		}
		return s;
	}

}
