public class DepthFirstPaths {

	private boolean[] marked; // used in DFS for keeping track of visited
								// vertices
	private int[] edgeTo; // stores edge : edgeTo[v]-previous. index in the
							// array is the vertex.
	private int s; // vertex on path from s to v.

	public DepthFirstPaths(Graph G, int s) {
		// Initialize structure
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = 0;
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		// Mark the current node as visited.
		// Recursively visit all the unmarked vertices w adj to v.
		marked[v] = true;
		for (int w : G.adj(v)) {
			// mark the current node as visited.
			if (!marked[w]) {
				// Recursively visit all the unmarked vertices w adj to v.
				dfs(G, w);
				// set edgeTo to previous node.
				edgeTo[w] = v;
			}
		}
	}
}
