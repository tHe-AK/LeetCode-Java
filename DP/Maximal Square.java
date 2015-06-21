public class Solution {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] rec = new int[row][col];
        
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    rec[i][j] = matrix[i][j] - '0';
                }
                else if (matrix[i][j] == '0') {
                    rec[i][j] = 0;
                }
                else {
                    rec[i][j] = Math.min(rec[i - 1][j - 1], Math.min(rec[i - 1][j], rec[i][j - 1])) + 1;
                }
                
                result = Math.max(result, rec[i][j]);
            }
        }
        
        return result * result;
    }
}
