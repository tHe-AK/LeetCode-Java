public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length < 0) {
            throw new IllegalArgumentException();
        }
        
        int n = values.length;
        
        if (n == 0) {
            return false;
        }
        
        if (n <= 2) {
            return true;
        }

        int[][] rec = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            rec[i][i] = values[i];
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                rec[i][j] = Math.max(values[i] - rec[i + 1][j], values[j] - rec[i][j - 1]);
            }
        }
        
        return rec[0][n - 1] > 0;
    }
}
