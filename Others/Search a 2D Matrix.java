public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;
        int mid;
        int value;
        
        while (low <= high) {
            mid = low + (high - low) / 2;
            value = matrix[mid / col][mid % col];
            if (value == target) {
                return true;
            }
            else if (value < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}
