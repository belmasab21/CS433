
public class StringSorter {
	
	public static void radixSort(String[] strings, int n) { // complete this method
		   int max = 5;
	        int[] digits = new int[n];
	        for (int x = max - 1; x > 0; x--) {
	            for (int i = 0; i < n; i++) {
	                if (x >= strings[i].length()) {
	                    digits[i] = 0;
	                } else {
	                    digits[i] = strings[i].charAt(x) - 96;
	                }

	            }
	            countSortOnLowerCaseCharacters(strings, n, digits);

	        }
	}

	private static void countSortOnLowerCaseCharacters(String[] strings, int n, int[] digits) { // complete this method
		  int[] digitCount = new int[27];
	        for (int i = 0; i < digitCount.length; i++) {
	            digitCount[i] = 0;
	        }
	        String[] temp = new String[n];
	        for (int i = 0; i < n; i++) {
	            digitCount[digits[i]]++;
	        }
	        for (int i = 1; i <= digitCount.length - 1; i++) {
	            digitCount[i] = digitCount[i - 1] + digitCount[i];
	        }
	        for (int i = n - 1; i >= 0; i--) {
	            temp[digitCount[digits[i]]-1] = strings[i];
	            digitCount[digits[i]]--;
	        }
	        for (int i = 0; i < temp.length; i++) {
	            strings[i] = temp[i];
	        }
	}
}
