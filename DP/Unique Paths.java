public class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException();
        }
        
        int[][] rec = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    rec[i][j] = 1;
                }
                else {
                    rec[i][j] = rec[i][j - 1] + rec[i - 1][j];
                }
            }
        }
        
        return rec[m - 1][n - 1];
    }
}