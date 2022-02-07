
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DJP extends Graph {

	public DJP(String filePath, GraphType type) throws FileNotFoundException {
		super(filePath, type);
	}

	public ArrayList<Edge> runDJP(int source) throws IndexOutOfBoundsException { // complete this function
		int distance[] = new int[numVertices];
		boolean closed[] = new boolean[numVertices];
		for (int i = 0; i < numVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
			closed[i] = false;
		}

		distance[source] = 0;
		PriorityQueue<PriorityQueueElement> open = new PriorityQueue<>(new PriorityQueueElementComparator());

		open.add(new PriorityQueueElement(source, 0));

		while (open.size() > 0) {
			int minVertex = open.poll().item;
			for (int i = 0; i < adjList.get(minVertex).size(); i++) {
				Edge adjEdge = adjList.get(minVertex).get(i);
				int adjVertex = adjEdge.dest;
				if (!closed[adjVertex]) {
					int dist = distance[minVertex] + adjEdge.weight;
					if (dist < distance[adjVertex]) {
						distance[adjVertex] = dist;
						open.add(new PriorityQueueElement(adjVertex, dist));
					}
				}
			}
			closed[minVertex] = true;
		}
		return distance;
	}
}
