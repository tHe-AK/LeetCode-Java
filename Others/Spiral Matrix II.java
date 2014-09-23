public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        
        int[][] matrix = new int[n][n];
        
        if (n == 0) {
            return matrix;
        }
        
        int count = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        
        while (true) {
            if (left > right) {
                break;
            }
            for (int j = left; j <= right; j++) {
                matrix[top][j] = count++;
            }
            top++;
            
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            right--;
            
            if (left > right) {
                break;
            }
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = count++;
            }
            bottom--;
            
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count++;
            }
            left++;
        }
        
        return matrix;
    }
}
