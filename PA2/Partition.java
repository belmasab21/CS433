
public class Partition {

	private static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	public static int[] partition(int[] array, int left, int right, int pivot) {
		int pivotIndex = left;
		int partitionIndex = (left - 1);
		int[] returnArray = new int[2];
		for (int k = left; k <= right; k++) {
			if (array[k] == pivot) {
				pivotIndex = k;
			}
			if (array[k] <= pivot) {
				partitionIndex++;
			}
		}
				swap(array, pivotIndex, partitionIndex);
				returnArray[1] = partitionIndex;

		int i = left, j = right;	
		while (i < j) {
			while (i <= partitionIndex && array[i] <= pivot) {
				i++;
			}
			while (j > partitionIndex && array[j] > pivot) {
				j--;
			}
			if (i < j) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
			j = partitionIndex-1;
			i = left;
			while ( i < j) {	
				while ((i <= partitionIndex) && array[i] < pivot) {
					i++;
				}
				while ((j > left) && array[j] == pivot) {
					j--;
				}
				if (i < j) {
					swap(array, i, j);
					i++;
					j--;
				}
			}
			returnArray[0] = i;
		//	returnArray[1] = j;
				
			return returnArray;		
		}		
	}	//complete this method


