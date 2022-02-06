import java.util.ArrayList;

public class LIS {

	public static ArrayList<Integer> longestIncreasingSubsequence(int[] arr, int len) { // complete this method
		int[] LIS = new int[len];
		int[] PRED = new int[len];
		for (int i = 0; i <= len-1; i++) {
			LIS[i] = 1;
			PRED[i] = -1;
			for (i = 0; i < i - 1; i++) {
				int maxIndex = 
			}
		}
	}

	private static void reverse(ArrayList<Integer> list) {
		for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
			int temp = list.get(j);
			list.set(j, list.get(i));
			list.set(i, temp);
		}
	}
}
