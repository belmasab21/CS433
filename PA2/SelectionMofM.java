
public class SelectionMofM {

	private static void insertionSort(int[] arr, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			int j = i, temp = arr[j];
			while (j > left && temp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}

	public static int select(int[] arr, int left, int right, int k) { // complete this method
		int n = right-left+1;
		if (left == right) {
			return arr[left];
		}
		if ((right - left + 1) <= 5) {
			insertionSort(arr, left, right);
			return arr[left + k - 1];
		}
		int[] Median = new int[n/5];
		int medianOfMedians = select(Median, 0, arr[n/5]-1, arr[n/5]/2);
		int[] partitionIndex = Partition.partition(arr, left, right, medianOfMedians);
		int i = partitionIndex[0];
		int j = partitionIndex[1];
		if (k >= j - left + 1 && k <= i - left + 1) {
			return medianOfMedians;
		}
		else if (k < j -left+1) {
			//insertionSort(arr, left, right);
			return select(arr, left, i - left + 1, k);
		}
		else {
			//insertionSort(arr, left, right);
			return select(arr, i + 1, right, k-(i-left+1));
		}
		
		}
	}



	

