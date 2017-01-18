public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int area = 0;
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return area;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        
        for (int i = 0; i < m; i++) {
            int curr = 0;
            
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    curr++;
                    left[j] = left[j] == 0 ? curr : Math.min(left[j], curr);
                }
                else {
                    height[j] = left[j] = curr = 0;
                }
            }
            
            curr = 0;
            
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    curr++;
                    right[j] = right[j] == 0 ? curr : Math.min(right[j], curr);
                    area = Math.max(area, height[j] * (left[j] + right[j] - 1));
                }
                else {
                    right[j] = curr = 0;
                }
            }
        }
        
        return area;
    }
}
