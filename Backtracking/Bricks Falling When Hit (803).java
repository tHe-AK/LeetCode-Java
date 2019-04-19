class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int M = grid.length;
        int N = grid[0].length;
        int[] res = new int[hits.length];
        int[][] delta = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

        for (int[] hit : hits) {
            int i = hit[0];
            int j = hit[1];
            grid[i][j]--;
        }
        
        for (int j = 0; j < N; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j, delta);
            }
        }

        for (int k = hits.length - 1; k >= 0; k--) {
            int i = hits[k][0];
            int j = hits[k][1];
            grid[i][j]++;

            if (grid[i][j] == 1 && isConnected(grid, i, j, delta)) {
                res[k] = dfs(grid, i, j, delta) - 1;
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int i, int j, int[][] delta) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = 2;
        int sum = 1;

        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            sum += dfs(grid, x, y, delta);
        }

        return sum;
    }
    
    private boolean isConnected(int[][] grid, int i, int j, int[][] delta) {
        if (i == 0) {
            return true;
        } else {
            for (int[] diff : delta) {
                int x = i + diff[0];
                int y = j + diff[1];
                
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 2) {
                    return true;
                }
            }
            
            return false;
        }
    }
}
