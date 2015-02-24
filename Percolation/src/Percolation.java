
public class Percolation { 
  private boolean[][] grid; // false = blocked, true = open.
  WeightedQuickUnionUF wuf;
  int gridSize;
  int NN;
 
  public Percolation(int N)               // create N-by-N grid, with all sites blocked {
  {	  
   	  if(N<=0)
   	  {
   		  throw new IllegalArgumentException();
   	  }
   	  else
   	  {
		  gridSize = N;
		  NN = N*N;
	   	  wuf = new WeightedQuickUnionUF(NN+2); // creates a Union Find Data structure with NxN + 2 virtual nodes
	   	  grid = new boolean[N][N];
	   	  
	   	  for(int i=0;i<N;i++)
	   	  {   		  
	   		  for(int j=0;j<N;j++)
	   		  {
	   			  grid[i][j] = false;
	   		  }
	   	  }   	  
	   	   	  
   	  }
  }
  
  private int ijtok(int i,int j)
  {
	  if (i<1 || j<1 || i>gridSize ||j>gridSize)
	  { 
		  return -1;
	  }
	  return (i-1)*gridSize + (j-1);
  }  
  
 
 public void open(int i, int j) // open site (row i, column j) if it is not open already
 {
	// open a site at i,j => create a union of (i-1,j), (i+1,j) (i,j-1),(i,j+1)
	 if(i > gridSize || i<1 || j> gridSize || j<1)
	 {
		 throw new ArrayIndexOutOfBoundsException();
	 }
	 else
	 {
		 // mark the spot to be open.
		 grid[i-1][j-1] = true; 
		 // perform union operations on the neighboring elements		 
		 int p = ijtok(i,j);		 
		 //up
		 int q = ijtok(i-1,j);		 
		 if(q!=-1) 
		 { 
			if(isOpen(i-1,j))
			{ 
				wuf.union(p, q);
			}
		 }	
		 //down
		 q = ijtok(i+1,j);
		 if(q!=-1) 
		 { 
			 if(isOpen(i+1,j))
			 {
				wuf.union(p, q); 
			 }			 
		 }
		 
		 //left
		 q = ijtok(i,j-1);
		 if(q!=-1) 
		 { 
			 if(isOpen(i,j-1))
			 {
				 wuf.union(p, q);
			 }
		 }		
		 
		 //right		 
		 q = ijtok(i,j+1);
		 if(q!=-1) 
		 { 
			 if(isOpen(i,j+1))
			 {
				 wuf.union(p, q);	 
			 }			 
		 }
		 
		 if(i==1)
		 {
			 wuf.union(p, NN);	 
		 }
		 
		 if(i==gridSize)
		 {
			 wuf.union(p, (NN+1));
		 }
	 }	 
 
 }
 
 public boolean isOpen(int i, int j) // is site (row i, column j) open?
 {
	 
	 return grid[i-1][j-1];  
 } 
 
 public boolean isFull(int i, int j) // is site (row i, column j) full?
 {
	 int p = ijtok(i,j);	 
	 return wuf.connected(p, gridSize*gridSize);
 }
 
 
 public boolean percolates()   // does the system percolate?
 {
	int NN = gridSize*gridSize;
    return wuf.connected(NN,NN+1);
 }  
 }
