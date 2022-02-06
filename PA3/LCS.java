public class LCS {

	public static String longestCommonSubsequence(final String x, final String y) { // complete this method
		int lenx = x.length();
		int leny = y.length();
		int[][] length = new int[lenx+1][leny+1];
		char[][] direction = new char[lenx+1][leny+1];
		for (int i = 0; i < lenx && i >= 0; i++) {
			for (int j = 0; j < leny && j >= 0; j++) {
		length[i][0] = 0;
		direction[i][0] = '\0';
		length[0][j] = 0; 
		direction[0][j] = '\0';
			}
		}
		for (int i = 1; i <= lenx; i++) {
			for (int j = 1; j <= leny; j++) {
				if (x.charAt(i-1) == y.charAt(j-1)) {
					length[i][j] = length[i-1][j-1] + 1;
					direction[i][j] = 'D';
				}
				else if (length[i-1][j] > length[i][j-1]) {
					length[i][j] = length[i-1][j];
					direction[i][j] = 'U';
				}
				else {
					length[i][j] = length[i][j-1];
					direction[i][j] = 'L';
				}
			}
		}
		String ans = "";
		while (direction[lenx][leny] != '\0') {
			if (direction[lenx][leny] == 'D') {
				ans += x.charAt(lenx-1);
				lenx = lenx-1;
				leny = leny-1;
				
			}
			else if (direction[lenx][leny] == 'U') {
				lenx--;
			}
			else {
				leny--;
			}
			//reverse(ans);
		}
		reverse(ans);
		return ans;
	}
    
    private static String reverse(String str) {
        StringBuilder rev = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            rev.append(str.charAt(i));
        }
        return rev.toString();
    }
}
