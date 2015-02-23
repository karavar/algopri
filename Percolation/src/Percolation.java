
public class Percolation {	
	
	private boolean[][] grid; // false = blocked, true = open.
		
	 public Percolation(int N)               // create N-by-N grid, with all sites blocked	{
	 {
		 for(int i=0;i<N;i++)
		 {
			 for(int j=0;j<N;j++)
			 {
				 grid[i][j] = false; //false = blocked
			 }
		 }
	 }
	
	public void open(int i, int j) // open site (row i, column j) if it is not open already
	{
		
	}
	
	public boolean isOpen(int i, int j) // is site (row i, column j) open?
	{
		
		return true;
	}	
	
	public boolean isFull(int i, int j) // is site (row i, column j) full?
	{
		
		return true;
	}
	
	public boolean percolates()   // does the system percolate?
	{
		
		return true;
	}
	
	public static void main(String[] args)
	{
		
	}
	

}
