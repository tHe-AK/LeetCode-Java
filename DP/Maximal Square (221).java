public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] rec = new int[row + 1][col + 1];
        
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    rec[i][j] = Math.min(rec[i - 1][j - 1], Math.min(rec[i - 1][j], rec[i][j - 1])) + 1;
                    maxLen = Math.max(maxLen, rec[i][j]);
                }
            }
        }
        
        return maxLen * maxLen;
    }
}
