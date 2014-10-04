public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }
        
        int area = 0;
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return area;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[] left = new int[col];
        int[] right = new int[col];
        int[] height = new int[col];
        
        for (int i = 0; i < col; i++) {
            left[i] = -1;
        }
        
        for (int i = col - 1; i >= 0; i--) {
            right[i] = col;
        }
        
        for (int i = 0; i < row; i++) {
            int start = -1;
            
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], start + 1);
                }
                else {
                    height[j] = 0;
                    start = j;
                    left[j] = -1;
                }
            }
            
            int end = col;
            
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], end - 1);
                    area = Math.max(area, height[j] * (right[j] - left[j] + 1));
                }
                else {
                    end = j;
                    right[j] = col;
                }
            }
        }
        
        return area;
    }
}