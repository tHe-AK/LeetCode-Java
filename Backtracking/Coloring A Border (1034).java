class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, - 1 }, { 0, 1 } };
        dfs(grid, r0, c0, grid[r0][c0], color, new boolean[grid.length][grid[0].length], delta);
        return grid;
    }
    
    private boolean dfs(int[][] grid, int i, int j, int target, int color, boolean[][] visited, int[][] delta) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return true;
        }
        
        if (visited[i][j]) {
            return false;
        }
        
        if (grid[i][j] != target) {
            return true;
        }
        
        visited[i][j] = true;
        boolean isBorder = false;
        
        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            
            if (dfs(grid, x, y, target, color, visited, delta)) {
                isBorder = true;
            }
        }
        
        if (isBorder) {
            grid[i][j] = color;
        }
        
        return false;
    }
}
