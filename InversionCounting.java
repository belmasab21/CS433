
public class InversionCounting {

	private final int mergedArray[];
	private final int array[];
	private final int n;

	public InversionCounting(int[] array, int n) {
		this.array = array;
		this.mergedArray = new int[n];
		this.n = n;
	}

	public int bruteForce() {
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (array[i] > array[j])
					count++;
		return count;
	}

	public int countInversions() {
		return countInversions(0, n - 1);
	}

	private int countInversions(int left, int right) { // complete this function
		if (left < right) {
			int mid = (left + right) / 2;
			int countL = countInversions(left, mid);
			int countR = countInversions(mid+1, right);
			int i = left;
			int j = mid;
			int k = right;
			int[] temp = new int[n];
			while ((i <= mid - 1) && (j <= right)) {

				if (array[i] <= array[j]) {
					temp[k++] = array[i++];
				}
				else {
					temp[k++] = array[j++];
				}
			}
			while (i <= mid - 1) {
				temp[k++] = array[i++];
			}
			while (j <= right) {
				temp[k++] = array[j++];
			}
			for (int x = left; x <= right; x++) {
				array[i] = temp[i];
			}
			int countC = temp[i];
			return countL + countR + countC;
		}
		return 0;
		
		
		/* if (left < right) {
			int mid = (left+right)/2;
			int[] leftArray = new int[mid];
			int[] rightArray = new int[mid];
			int countLeft = countInversions(left, mid);
			int countRight = countInversions(mid+1, right);		
			int countSwap = 0;
			for (int i = 0; i < leftArray.length; i++) {
				array[i] = leftArray[i];
			}
			for (int i = n-1; i < rightArray.length; i--) {
				array[i] = rightArray[i];
			}
		for (int i = 0; i < n; i++) {
			if (leftArray[i] > rightArray[i]) {	
				countSwap++;
				i++;
				}
			}
		return countLeft + countRight + countSwap;
		}
		return 0;
		*/
	}
}
