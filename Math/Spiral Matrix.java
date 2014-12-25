public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        
        while (true) {
            if (left > right) {
                break;
            }
            
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            if (top > bottom) {
                break;
            }
            
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            if (left > right) {
                break;
            }
            
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]);
            }
            bottom--;
            
            if (top > bottom) {
                break;
            }
            
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        
        return result;
    }
}