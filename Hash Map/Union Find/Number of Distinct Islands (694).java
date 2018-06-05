public class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<List<Integer>> set = new HashSet<>();
        int[][] delta = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> path = new ArrayList<>();
                    dfs(grid, i, j, path, -1, delta);
                    set.add(path);
                }
            }
        }

        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, List<Integer> path, int pos, int[][] delta) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        
        path.add(pos);
        grid[i][j] = 0;

        for (int k = 0; k < delta.length; k++) {
            int x = i + delta[k][0];
            int y = j + delta[k][1];
            dfs(grid, x, y, path, k, delta);
        }
    }
}

public class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<List<Integer>> set = new HashSet<>();
        int[][] delta = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> path = new ArrayList<>();
                    dfs(grid, i, j, path, i * col + j, delta);
                    set.add(path);
                }
            }
        }

        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, List<Integer> path, int start, int[][] delta) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        
        path.add(i * grid[0].length + j - start);
        grid[i][j] = 0;

        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            dfs(grid, x, y, path, start, delta);
        }
    }
}
