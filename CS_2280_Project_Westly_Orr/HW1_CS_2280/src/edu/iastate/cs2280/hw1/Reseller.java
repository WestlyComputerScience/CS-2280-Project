package edu.iastate.cs2280.hw1;


/**
 * 
 * @author <<Westly Orr>>
 * @date 09/14/2024
 * 
 * This one of the descendants of TownCell. The Reseller class is one of the 5 cells that can be put in a
 * neighborhood, and can be used to calculate the next cell.
 * 
 */

public class Reseller extends TownCell
{

	/*
	 * Constructor for Reseller
	 */
	public Reseller(Town p, int r, int c) 
	{
		super(p, r, c);
	}

	/**
	 * Gets the identity of the cell RESELLER
	 * 
	 * @return State
	 */
	public State who()
	{
		State r = State.RESELLER;
		return r;
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
		
		//checks for 3 or fewer casual neighbors
		if (nCensus[2] <= 3)
		{
			tc = new Empty(tNew, this.getRow(), this.getCol());
			return tc;
		}
		
		//checks if 3 or more empty cells
		else if(nCensus[1] >= 3)
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
			tc = new Reseller(tNew, this.getRow(), this.getCol());
			return tc;
		}
	}
}
