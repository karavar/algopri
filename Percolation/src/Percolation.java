
public class Percolation { 
 
 //private boolean[][] grid; // false = blocked, true = open.
  WeightedQuickUnionUF wuf;
  int gridSize;
  
  public Percolation(int N)               // create N-by-N grid, with all sites blocked {
  {	  
   	  if(N<=0)
   	  {
   		  throw new IllegalArgumentException();
   	  }
   	  else
   	  {
	  gridSize = N;
   	  wuf = new WeightedQuickUnionUF(N*N); // this creates a single dimension array of size N*N.
   	  }
  }
  
  public int ijtok(int i,int j)
  {
	  return i*gridSize + j ;
  }  
  
 
 public void open(int i, int j) // open site (row i, column j) if it is not open already
 {
	// open a site at i,j => create a union of (i-1,j), (i+1,j) (i,j-1),(i,j+1)
	 if(i >= gridSize || i<0 || j>= gridSize || j<0)
	 {
		 throw new ArrayIndexOutOfBoundsException();
	 }
	 else
	 {
		 	 
		 int p = ijtok(i,j);
		 wuf.union(p, ijtok(i-1,j));
		 wuf.union(p, ijtok(i+1,j));
		 wuf.union(p, ijtok(i,j-1));
		 wuf.union(p, ijtok(i,j+1));
		 
		 
	 }
	 
	 
	 
	   
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
	 Percolation p = new Percolation(4);	 
	 p.wuf.union(0, 10); 
 }
 

}
