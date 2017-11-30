import java.util.Stack;

public class GraphAdjMatrix implements Graph {

	private int[][] edges;

	public GraphAdjMatrix(int vt) {
		edges = new int[vt][vt];
	}

	public void addEdge(int src, int tar) {
		edges[src][tar] = 1;
	}

	public int[] neighbors(int vertex) {
		
		int index = 0;
		int[] vertices = new int[outDegree(vertex)];

		for (int i = 0; i < edges.length; i++) {
			if (edges[vertex][i] == 1) {
				vertices[index] = i;
				index++;
			}
		}
		return vertices;
	}

	public void topologicalSort() {

		boolean[] visited = new boolean[edges.length];

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				explore(i, visited);
			}
		}

	}

	private void explore(int vertex, boolean[] visited) {

		Stack<Integer> s = new Stack<Integer>();
		s.push(new Integer(vertex));

		while (!s.empty()) {

			int pop = s.pop();
			System.out.print(pop + " ");
			visited[vertex] = true;

			int[] neighbors = neighbors(pop);

			for (int i = 0; i < neighbors.length; i++) {
				if (!visited[neighbors[i]]) {
					s.push(new Integer(neighbors[i]));
					visited[neighbors[i]] = true;
				}
			}

		}
		System.out.println();

	}

	private int outDegree(int vertex) {

		int degree = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[vertex][i] != Integer.MAX_VALUE && edges[vertex][i] != 0) {
				degree++;
			}
		}
		return degree;
	}

}