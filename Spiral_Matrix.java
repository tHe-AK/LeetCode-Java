public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        
        int x = matrix.length;
        int y = matrix[0].length;
        int left = 0;
        int right = y - 1;
        int top = 0;
        int bottom = x - 1;
        ArrayList<Integer> rec = new ArrayList<Integer>();
        
        while (true) {
            if (left > right) {
                break;
            }
            for (int j = left; j <= right; j++) {
                rec.add(matrix[top][j]);
            }
            top++;
            
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                rec.add(matrix[i][right]);
            }
            right--;
            
            if (left > right) {
                break;
            }
            for (int j = right; j >= left; j--) {
                rec.add(matrix[bottom][j]);
            }
            bottom--;
            
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                rec.add(matrix[i][left]);
            }
            left++;
        }
        
        return rec;
    }
}
