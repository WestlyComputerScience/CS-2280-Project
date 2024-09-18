package edu.iastate.cs2280.hw1;


/**
 * 
 * @author <<Westly Orr>>
 * @date 09/14/2024
 * 
 * This one of the descendants of TownCell. The Streamer class is one of the 5 cells that can be put in a
 * neighborhood, and can be used to calculate the next cell.
 * 
 */


public class Streamer extends TownCell
{

	/*
	 * Constructor for Streamer
	 */
	public Streamer(Town p, int r, int c) 
	{
		super(p, r, c);
	}

	/**
	 * Gets the identity of the cell STREAMER
	 * 
	 * @return State
	 */
	public State who()
	{
		State s = State.STREAMER;
		return s;
	}
	
	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public TownCell next(Town tNew)
	{
		TownCell tc;
		this.census(nCensus);
		
		//int z is to add up empty and outage neighbors
		int z = nCensus[1] + nCensus[3];
		
		//checks if it cell can be reseller
		if (z <= 1)
		{
			tc = new Reseller(tNew, this.getRow(), this.getCol());
			return tc;
		}
		
		//checks for resellers
		else if (nCensus[0] > 0)
		{
			tc = new Outage(tNew, this.getRow(), this.getCol());
			return tc;
		}
		
		//checks for outage
		else if (nCensus[3] >= 0)
		{
			tc = new Empty(tNew, this.getRow(), this.getCol());
			return tc;
		}
		
		//checks if it could be a streamer
		else if(nCensus[2] >= 5)
		{
			tc = new Streamer(tNew, this.getRow(), this.getCol());
			return tc;
		}
		
		//if none of the above applies
		else
		{
			tc = new Streamer(tNew, this.getRow(), this.getCol());
			return tc;
		}
	}
}
