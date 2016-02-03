public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] record = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = Math.max(result, helper(matrix, record, i, j));
            }
        }
        
        return result;
    }
    
    private int helper(int[][] matrix, int[][] record, int i, int j) {
        if (record[i][j] > 0) {
            return record[i][j];
        }
        
        int[] deltaX = new int[] {-1, 1, 0, 0};
        int[] deltaY = new int[] {0, 0, -1, 1};
        
        for (int k = 0; k < deltaX.length; k++) {
            int x = i + deltaX[k];
            int y = j + deltaY[k];
            
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                record[i][j] = Math.max(record[i][j], helper(matrix, record, x, y));
            }
        }
        
        return ++record[i][j];
    }
}
