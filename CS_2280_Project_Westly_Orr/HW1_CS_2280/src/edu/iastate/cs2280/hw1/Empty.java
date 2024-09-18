package edu.iastate.cs2280.hw1;


/**
 * 
 * @author <<Westly Orr>>
 * @date 09/14/2024
 * 
 * This one of the descendants of TownCell. The Empty class is one of the 5 cells that can be put in a
 * neighborhood, and can be used to calculate the next cell.
 * 
 */

public class Empty extends TownCell
{

	/*
	 * Constructor for Empty
	 */
	public Empty(Town p, int r, int c) 
	{
		super(p, r, c);
	}

	/**
	 * Gets the identity of the cell EMPTY
	 * 
	 * @return State
	 */
	public State who()
	{
		State e = State.EMPTY;
		return e;
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
		else
		{
			tc = new Casual(tNew, this.getRow(), this.getCol());
			return tc;
		}
	}
}
