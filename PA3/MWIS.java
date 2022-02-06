import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MWIS extends Tree {

	public int computedSum[];
	boolean isIncludedSumLarger[];
	boolean isInSet[];

	public MWIS(final String filePath) throws FileNotFoundException {
		super(filePath);
		computedSum = new int[numNodes];
		isIncludedSumLarger = new boolean[numNodes];
		isInSet = new boolean[numNodes];
		for (int i = 0; i < numNodes; i++) {
			computedSum[i] = Integer.MIN_VALUE;
			isIncludedSumLarger[i] = false;
			isInSet[i] = false;
		}
	}

	public int computeSum(int node) { // complete this function
		double inf = Double.POSITIVE_INFINITY;
		double negInf = Double.NEGATIVE_INFINITY;
		if (computedSum[node] != negInf) {
			return computedSum[node];
		}
		int excl = 0;
		int incl = weights[node];
		ArrayList<Integer> children = new ArrayList<Integer>();
		for (int i = 0; i < children.size(); i++) {
			 int child = children.get(i);
			excl = excl + computeSum(child);
			int grandChildren = children.get(child);
			incl = incl + computeSum(grandChildren);
		}
		if ( incl > excl) {
			computedSum[node] = incl;
			isIncludedSumLarger[node] = true;
		}
		else {
			computedSum[node] = excl;
		}
		return computedSum[node];
	}

	public void computeSet(int root) { // complete this function
		if (isIncludedSumLarger[root] == true) {
			isInSet[root] = true;
		}
		for (int i = 0; i < adjList.size(); i++) {
		computeSetHelper(numNodes, root);
		}
	}
	

	private void computeSetHelper(int node, int parent) { // complete this function
		if (isIncludedSumLarger[node] == true && parent == 0) {
			isInSet[node] = true;
		}
		for (int i = 0; i < adjList.size(); i++) {
			computeSetHelper(numNodes, node);
		}
	}
}
