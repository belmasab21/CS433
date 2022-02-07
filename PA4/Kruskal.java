
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal extends Graph {

	public Kruskal(String filePath, GraphType type) throws FileNotFoundException {
		super(filePath, type);
	}

	public ArrayList<Edge> runKruskal() { // complete this function
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		for (int i = 0; i < adjList.size(); i++) {
			for (int j = 0; j < adjList.get(i).size(); j++) {
				edgeList.add(adjList.get(i).get(j));				
			}
		}
		Collections.sort(edgeList, new WeightComparator());
		UnionFind objUF = new UnionFind(numVertices);
		ArrayList<Edge> newArray = new ArrayList<Edge>();
		int numEdgesAdded = 0;
		for (int j = 0; j < edgeList.size(); j++) {
			for (int k = 0; k < edgeList.size(); k++) {
				Edge e = edgeList.get(k);
				int src = e.src;
				int dest = e.dest;
				if (objUF.find(src) != objUF.find(dest)) {
					objUF.doUnion(src, dest);
					newArray.add(e);
					numEdgesAdded++;
					if (numEdgesAdded == (numVertices - 1)) {
						break;
					}
				}
			}		
		}
		return newArray;
	}
	class WeightComparator implements Comparator<Edge> {
		@Override
	public int compare(Edge one, Edge two) {
		if (one.weight > two.weight) {
			return 1;
		}
		else if (one.weight == two.weight) {
			return 0;
		}
		else {
			return -1;
			}
		}
	}
}
