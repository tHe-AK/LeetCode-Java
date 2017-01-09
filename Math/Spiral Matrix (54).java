public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        
        while (true) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            
            if (++top > bottom) {
                break;
            }
            
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            
            if (left > --right) {
                break;
            }
            
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]);
            }
            
            if (top > --bottom) {
                break;
            }
            
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            
            if (++left > right) {
                break;
            }
        }
        
        return result;
    }
}
