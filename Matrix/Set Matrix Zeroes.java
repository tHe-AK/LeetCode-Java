public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean rowZero = false;
        boolean colZero = false;
        
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }
            
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                rowZero = true;
                break;
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (rowZero) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if (colZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}