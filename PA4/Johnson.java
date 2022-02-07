
import java.util.ArrayList;

public class Johnson extends Graph {

	public Johnson(final Graph graph) {
		super(graph);
	}

	public int[][] execute() throws Exception { // complete this method
		int inf = Integer.MAX_VALUE;
		adjList.add(new ArrayList<Edge>());
		for (int i = 0; i < numVertices; i++) {
			Edge e = new Edge(numVertices, i, 0);
			adjList.get(numVertices).add(e);		
			}
		numEdges = numEdges + numVertices;
		numVertices++;	
		BellmanFord bellmanFord = new BellmanFord(this);
		int[] phi = bellmanFord.execute(numVertices - 1);
		adjList.remove(adjList.size() - 1);
		numVertices--;
		numEdges = numEdges - numVertices;
		if (phi == null) {
			return null;
		}
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < adjList.get(i).size(); j++) {
				Edge e = adjList.get(i).get(j);
				e.weight = e.weight + phi[e.src]- phi[e.dest]; 
			}
		}
		int[][] allPairMatrix = new int[numVertices][];
		Dijkstra dij = new Dijkstra(this);
		for (int i = 0; i < numVertices; i++) {
			allPairMatrix[i] = dij.execute(i);
		}
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				if (i != j && allPairMatrix[i][j] != inf) {
					allPairMatrix[i][j] = allPairMatrix[i][j] - phi[i] + phi[j];
				}
			}			
		}
		for (int j = 0; j < numVertices; j++) {
			for (int k = 0; k < adjList.get(j).size(); k++) {
				Edge e = adjList.get(j).get(k);	
				e.weight = e.weight - phi[e.src] + phi[e.dest];
			}
		}
		return allPairMatrix;
	}
}
	
