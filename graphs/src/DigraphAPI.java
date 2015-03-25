public interface DigraphAPI {

	void addEdge(int v, int w); // add edge v-w

	Iterable<Integer> adj(int v); // vertices adjacent to v

	int V(); // number of vertices

	int E(); // number of edges

	String toString(); // string representation

	public Digraph reverse(); // returns the reverse of a graph.

}
