public interface GraphAPI {

	void AddEdge(int v, int w); // add edge v-w

	Iterable<Integer> adj(int v); // vertices adjacent to v

	int V(); // number of vertices

	int E(); // number of edges

	String toString(); // string representation

}
