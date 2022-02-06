import java.util.ArrayList;
import java.util.Collections;

public class Knapsack01 {
	
	public static int findOptimalProfit(final int profits[], final int weights[], int numElements, int capacity) { // complete this function
		int[] currentRow = new int[capacity+1];
		int[] prevRow = new int[capacity+1];
		for (int i = 0; i < prevRow.length; i++) {
			prevRow[i] = 0;
		}
		for (int i = 0; i < numElements; i++) {
			if (weights[i] > capacity) {
				continue;
			}
			for (int k = 0; k < weights[i] && k >= 0; k++) {
			currentRow[k] = prevRow[k];
			}
			for (int j = weights[i]; j <= capacity; j++) {
				currentRow[j] = Math.max(prevRow[j], (prevRow[j-weights[i]] + profits[i]));
			}
			for (int a = 0; a < prevRow.length; a++) {
				prevRow[a] = currentRow[a];
			}
		}
		return currentRow[capacity];
	}
}
