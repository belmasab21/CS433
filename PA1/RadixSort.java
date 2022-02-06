import java.util.Arrays;

public class RadixSort {

	private final int[] array;
	private final int n;

	public RadixSort(int array[], int length) {
		this.array = array;
		this.n = length;
	}

	private static void countSortOnDigits(int A[], int n, int digits[]) { // complete this function
		int[] C = new int [10];
		for (int i = 0; i < C.length; i++) {
			C[i] = 0;
		}
		int T[] = new int[n];
		for (int i = 0; i <= n-1; i++) {
			C[digits[i]]++;
		}
		for (int i = 1; i <= 9; i++) {
			C[i] = C[i-1] + C[i];
		}
		for (int i = n - 1; i >= 0; i--) {
			C[digits[i]]--;
			T[C[digits[i]]] = A[i];
		}
		for (int i = 0; i < n; i++) {
			A[i] = T[i];
		}
	}

	private static void radixSortNonNeg(int A[], int n) { // complete this function
		int max = A[0];
		for (int i = 0; i < n; i++) {
			if (A[i] > max) {
				max = A[i];
				}
			}
		//int M = A[max];
		int[] digits = new int[n];
		int e = 1;
		while (max/e > 0) {
			for (int i = 0; i <= n - 1; i++) {
				digits[i] = (A[i]/e)%10;
			}
			countSortOnDigits(A, n, digits);
			e = e*10;
		}
	}

	void radixSort() { // complete this function
	int min = array[0];
	for (int i = 0; i < n; i++) {
		if (array[i] < min) {
			min = array[i];
			}
		}
	if (min > 0) {
		radixSortNonNeg(array, n);
		return;
		}
	for (int i = 0; i < n; i++) {
		array[i] = array[i] - min;
		}
	radixSortNonNeg(array, n);
	for (int i = 0; i < n; i++) {
		array[i] = array[i] + (min);
		}
	}
}
