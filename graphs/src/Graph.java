public class Graph implements GraphAPI {
	// This is an adjacency-list implementation of a Graph.

	private final int V;
	private Bag<Integer>[] adj;

	@SuppressWarnings("unchecked")
	Graph(int V) // create an empty graph with V vertices
	{
		// set graph size.
		this.V = V;

		// instantiate adj-list bag
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}

	@SuppressWarnings("unchecked")
	Graph(In in) {
		// set graph size.
		this.V = in.readInt();
		// instantiate adj-list bag
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < this.V; v++) {
			adj[v] = new Bag<Integer>();
		}

		// add edges
		int edgeCount = in.readInt();
		for (int e = 0; e < edgeCount; e++) {
			int v = in.readInt();
			int w = in.readInt();
			AddEdge(v, w);
		}

	}

	@SuppressWarnings("unused")
	public static int degree(Graph G, int v) {
		int degree = 0;
		for (int w : G.adj(v)) {
			degree++;
		}
		return degree;
	}

	public static int maxDegree(Graph G) {
		int maxDegree = 0;
		int vertices = G.V();
		for (int v = 0; v < vertices; v++) {
			int dg = degree(G, v);
			if (dg > maxDegree) {
				maxDegree = dg;
			}
		}
		return maxDegree;
	}

	public static double averageDegree(Graph G) {
		return 2.0 * G.E() / G.V();
	}

	public static int numberOfSelfLoops(Graph G) {
		int count = 0;
		int vertices = G.V();
		for (int v = 0; v < vertices; v++) {
			for (int w : G.adj(v)) {
				if (v == w) {
					count++;
				}
			}
		}
		return (count / 2); // each edge counted twice
	}

	@Override
	public void AddEdge(int v, int w) {
		// TODO Auto-generated method stub
		adj[v].add(w);
		adj[w].add(v);

	}

	@Override
	public Iterable<Integer> adj(int v) {
		// TODO Auto-generated method stub
		return adj[v];
	}

	@Override
	public int V() {
		// TODO Auto-generated method stub
		return this.V;
	}

	@Override
	public int E() {
		// TODO Auto-generated method stub
		int edgeCount = 0;

		for (int v = 0; v < this.V; v++) {
			edgeCount += this.adj[v].size();
		}
		return (edgeCount / 2);
	}
}
