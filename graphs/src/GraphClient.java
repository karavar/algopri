
public class GraphClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		In in = new In(args[0]);
		Graph G = new Graph(in);
		
		for(int v=0;v<G.V();v++)
		{
			for(int w:G.adj(v))
			{
				StdOut.println(v+ "-" + w);
			}
		}
	}

}
