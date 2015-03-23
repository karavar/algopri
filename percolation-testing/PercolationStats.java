
public class PercolationStats {
	private int N; // grid size
	private int T; // number of experiments
	private double[] openSitesFraction; //array to store #of open sites at which system percolates.	
	
	public PercolationStats(int n, int t)     // perform T independent experiments on an N-by-N grid
	{
		N = n;
		T = t;
		if(N<1 || T<1 )
		{
			throw new java.lang.IllegalArgumentException();
		}
		else
		{
			int totalsites = N*N;
			openSitesFraction = new double[T];
			
			//perform experiments T times;
			for(int expIndex=0; expIndex<T;expIndex++)
			{
				Percolation p = new Percolation(N);
				int openCount = 0;			
				while(!p.percolates())
				{
					int i = StdRandom.uniform(1, N+1);					
					int j = StdRandom.uniform(1, N+1);
					if(!p.isOpen(i, j))
					{
						openCount++;
						p.open(i, j);
					}					
				}
				openSitesFraction[expIndex] = (double) openCount/totalsites;
			}				
		}
	}
	
/*	private void printOpenSiteFractions()
	{
		for(int i=0;i<T;i++)
		{
			System.out.println(openSitesFraction[i]);
		}
	}*/
	
	public double mean()                      // sample mean of percolation threshold
	{
		return StdStats.mean(openSitesFraction);
	}
	public double stddev()                    // sample standard deviation of percolation threshold
	{
		return StdStats.stddev(openSitesFraction);
	}
	public double confidenceLo()              // low  endpoint of 95% confidence interval
	{
		return (mean() - (1.96*stddev()/Math.sqrt(T)));
	}
	public double confidenceHi()              // high endpoint of 95% confidence interval
	{
		return (mean()+ (1.96*stddev()/Math.sqrt(T)));
	}
	public static void main(String[] args)    // test client (described below)
	{
		PercolationStats ps = new PercolationStats(200,100);		
		System.out.println("mean " + ps.mean() + " ");
		System.out.println("stddev " + ps.stddev() + " ");
		System.out.println("95% confidence interval " + ps.confidenceLo() + ", " + ps.confidenceHi());
	}

}
