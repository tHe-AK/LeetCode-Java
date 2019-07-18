class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[] res = new int[1];
        int[][] delta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int startX = 0;
        int startY = 0;
        int empty = 1;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        
        dfs(grid, startX, startY, empty, delta, res);
        return res[0];
    }
    
    private void dfs(int[][] grid, int i, int j, int empty, int[][] delta, int[] res) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) {
            return;
        }
        
        if (grid[i][j] == 2) {
            if (empty == 0) {
                res[0]++;
            }
            
            return;
        }
        
        grid[i][j] = -1;
        
        for (int[] diff : delta) {
            dfs(grid, i + diff[0], j + diff[1], empty - 1, delta, res);
        }
        
        grid[i][j] = 0;
    }
}
