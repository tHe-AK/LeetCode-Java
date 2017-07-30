public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = mid / col;
            int y = mid % col;
            
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}
