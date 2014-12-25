public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        int[][] rec = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int cur = 1;
        
        while (true) {
            if (left > right) {
                break;
            }
            
            for (int j = left; j <= right; j++) {
                rec[top][j] = cur;
                cur++;
            }
            top++;
            
            if (top > bottom) {
                break;
            }
            
            for (int i = top; i <= bottom; i++) {
                rec[i][right] = cur;
                cur++;
            }
            right--;
            
            if (left > right) {
                break;
            }
            
            for (int j = right; j >= left; j--) {
                rec[bottom][j] = cur;
                cur++;
            }
            bottom--;
            
            if (top > bottom) {
                break;
            }
            
            for (int i = bottom; i >= top; i--) {
                rec[i][left] = cur;
                cur++;
            }
            left++;
        }
        
        return rec;
    }
}