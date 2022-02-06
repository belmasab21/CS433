
import java.util.Random;

public class SelectionRandom {

	private static Random rand = new Random(System.currentTimeMillis());

	private static int generateRandomPivot(int[] array, int left, int right) {
		int pivotIndex = left + rand.nextInt(right - left + 1);
		return array[pivotIndex];
	}

	public static int select(int[] arr, int left, int right, int k) { // complete this method
	
		if (left == right) {
			return arr[left];
		}
		int pivot = generateRandomPivot(arr, left, right);
		
		int[] partitionIndex = Partition.partition(arr, left, right, pivot);
		int i = partitionIndex[0]; // lower
		int j = partitionIndex[1]; // upper

		if (k >= i-left+1 && k <= j-left+1) {
			return pivot;
		}
		else if (k < i-left+1) {
			return select(arr, left, partitionIndex[0]-1, k);
		}
		else {
			return select(arr, partitionIndex[0]+1, right, k-(partitionIndex[0]-left+1));
		}
	}
}
