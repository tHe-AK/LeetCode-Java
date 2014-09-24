public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix[0] == null || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException();
        }

        if (matrix.length <= 1) {
            return;
        }
        
        int len = matrix.length;
        
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = temp;
            }
        }
    }
}