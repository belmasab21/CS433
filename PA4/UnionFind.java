import java.util.ArrayList;

public class UnionFind {

	ArrayList<ArrayList<Integer>> representatives;

	public UnionFind(int initialNumSets) { // complete this constructor
		representatives = new ArrayList <ArrayList<Integer>>(initialNumSets);
		for (int x = 0; x < initialNumSets; x++) {
			ArrayList<Integer> t = new ArrayList<Integer>();
			representatives.add(t);
			makeSet(x);
		}
	}

	public void makeSet(int x) { // complete this function
		ArrayList<Integer> da = new ArrayList<Integer>();
		da.add(x);
		representatives.set(x, da);
	}

	public ArrayList<Integer> find(int x) { // complete this function
		return representatives.get(x);
	}

	private void append(ArrayList<Integer> arg1, ArrayList<Integer> arg2) { // complete this function
		while (arg2.size() != 0) {
			int x = arg2.get(arg2.size() - 1);
			arg2.remove(arg2.size() - 1);
			representatives.set(x, arg1);
			arg1.add(x);
		}
	}

	public void doUnion(int x, int y) { // complete this function
		ArrayList<Integer> daX = find(x);
		ArrayList<Integer> daY = find(y);
		if (daX != daY) {
			if (daX.size() >= daY.size()) {
				append(daX, daY);
			}
			else {
				append(daY, daX);
			}
		}
	}
}
