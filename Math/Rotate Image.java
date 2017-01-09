public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                swap(matrix, i, j, i, len - 1 - j);
            }
        }
    }
    
    private void swap(int[][] matrix, int i, int j, int x, int y) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}

public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }
}
