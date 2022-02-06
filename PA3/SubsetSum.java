import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class SubsetSum {

	public static boolean isSumPossible(final int elements[], int numElements, int target) { // complete this function
		TreeSet<Integer> sums = new TreeSet<Integer>();
		sums.add(0);
		for (int i = 0; i < numElements; i++) {
			ArrayList<Integer> values = new ArrayList<Integer>(sums);
			Iterator<Integer> it = values.iterator();
			while (it.hasNext()) {
				int currentVal = it.next();
			}
			for (int j = 0; j < values.size(); j++) {
				int val = elements[i] + values.get(j);
				if (val == target) {
					return true;
				}
				else if (val < target) {
					sums.add(val);
				}
			}			
		}
		return false;
	}
}
