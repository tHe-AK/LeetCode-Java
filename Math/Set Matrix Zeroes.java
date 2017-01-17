public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean col = false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row = true;
                    } else if (j == 0) {
                        col = true;
                    } else {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
        }
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i > 0 && j > 0 && matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                } else if (i == 0 && row) {
                    matrix[0][j] = 0;
                } else if (j == 0 && col) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
