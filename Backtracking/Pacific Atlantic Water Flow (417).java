public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        int[][] delta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        
        for (int i = 0; i < row; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific, delta);
            dfs(matrix, i, col - 1, Integer.MIN_VALUE, atlantic, delta);
        }
        
        for (int j = 0; j < col; j++) {
            dfs(matrix, 0, j, Integer.MIN_VALUE, pacific, delta);
            dfs(matrix, row - 1, j, Integer.MIN_VALUE, atlantic, delta);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[] { i, j });
                }
            }
        }

        return result;
    }

    private void dfs(int[][] matrix, int i, int j, int pre, boolean[][] visited, int[][] delta) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] < pre) {
            return;
        }
        
        visited[i][j] = true;

        for (int[] diff : delta) {
            dfs(matrix, i + diff[0], j + diff[1], matrix[i][j], visited, delta);
        }
    }
}
