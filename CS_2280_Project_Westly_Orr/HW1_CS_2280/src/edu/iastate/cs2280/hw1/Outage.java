package edu.iastate.cs2280.hw1;


/**
 * 
 * @author <<Westly Orr>>
 * @date 09/14/2024
 * 
 * This one of the descendants of TownCell. The Outage class is one of the 5 cells that can be put in a
 * neighborhood, and can be used to calculate the next cell.
 * 
 */

public class Outage extends TownCell
{
	
	/*
	 * Constructor for Outage
	 */
	public Outage(Town p, int r, int c) 
	{
		super(p, r, c);
	}

	/**
	 * Gets the identity of the cell OUTAGE
	 * 
	 * @return State
	 */
	public State who()
	{
		State o = State.OUTAGE;
		return o;
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
		
		tc = new Empty(tNew, this.getRow(), this.getCol());
		return tc;
	}
}
