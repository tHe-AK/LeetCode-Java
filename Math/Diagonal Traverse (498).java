public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int[][] delta = { { -1, 1 }, { 1, -1 } };
        int row = 0;
        int col = 0;
        int dir = 0;
        
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += delta[dir][0];
            col += delta[dir][1];
            
            if (row >= m) {
                row = m - 1;
                col += 2;
                dir = 1 - dir;
            } else if (col >= n) {
                row += 2;
                col = n - 1;
                dir = 1 - dir;
            } else if (row < 0) {
                row = 0;
                dir = 1 - dir;
            } else if (col < 0)  {
                col = 0;
                dir = 1 - dir;
            } 
        }
        
        return result;
    }
}
