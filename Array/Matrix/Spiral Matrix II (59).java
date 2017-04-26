public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        if (n == 0) {
            return matrix;
        }
        
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int count = 1;
        
        while (true) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = count++;
            }
            
            if (++top > bottom) {
                break;
            }
            
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            
            if (left > --right) {
                break;
            }
            
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = count++;
            }
            
            if (top > --bottom) {
                break;
            }
            
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count++;
            }
            
            if (++left > right) {
                break;
            }
        }
        
        return matrix;
    }
}
