public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] cache = new int[row][col];
        int[][] delta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1} };
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = Math.max(result, dfs(matrix, cache, i, j, delta));
            }
        }
        
        return result;
    }
    
    private int dfs(int[][] matrix, int[][] cache, int i, int j, int[][] delta) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }

        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, cache, x, y, delta));
            }
        }
        
        return ++cache[i][j];
    }
}
