package edu.iastate.cs2280.hw1;

/**
 * 
 * @author <<Westly Orr>>
 * @date 09/14/2024
 * 
 *	This is the superclass for all cell objects. They'll use abstract methods like who() and next()
 *  in order to perform their functions. Also, this is used to receive information about a TownCell object,
 *  and perform a census of what's around the cell (neighbors)
 *
 */
public abstract class TownCell {

	protected Town plain;  //the town being used with the cell
	protected int row;     //the row indices for this cell
	protected int col;     //the column indices for this cell


	// constants to be used as indices.
	protected static final int RESELLER = 0;  //The reseller indices for nCensus array
	protected static final int EMPTY = 1;  //The Empty indices for nCensus array
	protected static final int CASUAL = 2;  //The Casual indices for nCensus array
	protected static final int OUTAGE = 3;  //The Outage indices for nCensus array
	protected static final int STREAMER = 4;  //The Streamer indices for nCensus array

	public static final int NUM_CELL_TYPE = 5;  //The total length of nCensus array

	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];  //arrow used to take census

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}

	/**
	 * Checks all neighborhood cell types in the neighborhood.
	 *  
	 * @param nCensus: counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0; 
		nCensus[EMPTY] = 0; 
		nCensus[CASUAL] = 0; 
		nCensus[OUTAGE] = 0; 
		nCensus[STREAMER] = 0; 

		//checks below the cell
		this.censusCheckHelper(nCensus, row-1, col);

		//checks above the cell
		this.censusCheckHelper(nCensus, row+1, col);

		//checks to the left and right of cell
		if(col - 1 >= 0)
		{
			int x = this.censusStateCheckHelper(row, col-1);
			nCensus[x] = nCensus[x] + 1;
		}
		if(col + 1 <= plain.grid[0].length - 1)
		{
			int x = this.censusStateCheckHelper(row, col+1);
			nCensus[x] = nCensus[x] + 1;
		}
	}
	
	/**
	 * This is a getter method for a TownCell object's row
	 *  
	 * @return returns the row of TownCell object
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * This is a getter method for a TownCell object's col
	 *  
	 * @return returns the col of TownCell object
	 */
	public int getCol()
	{
		return col;
	}
	
	/**
	 * This method is used to return the indices of what kind of cell we're dealing with.
	 *  
	 * @param r: the row of the TownCell object
	 * @param c: the col of the TownCell object
	 * @return returns the index of what TownCell object it is.
	 */
	public int censusStateCheckHelper(int r, int c)
	{
		State z = plain.getGrid(r, c).who();
		State cas = State.CASUAL;
		State res = State.RESELLER;
		State out = State.OUTAGE;
		State emp = State.EMPTY;

		if (z == res)
		{
			return 0;
		}
		else if (z == emp)
		{
			return 1;
		}
		else if (z == cas)
		{
			return 2;
		}
		else if (z == out)
		{
			return 3;
		}
		else
		{
			return 4;
		}
	}
	
	/**
	 * This method is used to check the above and below neighbors for a cell (if present)
	 *  
	 * @param nCensus[]: the array to update if it finds a neighbor present
	 * @param r: the row of the TownCell object
	 * @param c: the col of the TownCell object
	 * @return returns the index of what TownCell object it is.
	 */
	public void censusCheckHelper(int nCensus[], int row, int col)
	{
		//checks above and below for cell
		if (row <= plain.grid.length - 1 && row >= 0)
		{
			if(col - 1 >= 0)
			{
				int x = this.censusStateCheckHelper(row, col-1);
				nCensus[x] = nCensus[x] + 1;
			}
			if(col >= 0)
			{
				int x = this.censusStateCheckHelper(row, col);
				nCensus[x] = nCensus[x] + 1;
			}
			if(col + 1 <= plain.grid[0].length -1)
			{
				int x = this.censusStateCheckHelper(row, col+1);
				nCensus[x] = nCensus[x] + 1;
			}
		}
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
	
}
