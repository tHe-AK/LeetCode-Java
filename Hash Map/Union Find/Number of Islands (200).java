public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        int[][] delta = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, delta);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int[][] delta) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        for (int[] diff : delta) {
            dfs(grid, i + diff[0], j + diff[1], delta);
        }
    }
}

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[] rec = new int[m * n];
        Arrays.fill(rec, -1);
        int count = 0;
        int[][] delta = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int curr = getIndex(i, j, n);
                    rec[curr] = curr;
                    count++;
    
                    for (int[] diff : delta) {
                        int x = i + diff[0];
                        int y = j + diff[1];
                        
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            int neighbor = getIndex(x, y, n);
                            
                            if (rec[neighbor] != -1) {
                                int root = neighbor;
        
                                while (root != rec[root]) {
                                    root = rec[root];
                                }
                                                        
                                rec[neighbor] = root;
                            
                                if (curr != root) {
                                    rec[curr] = root;
                                    curr = root;
                                    count--;
                                }
                            }
                        } 
                    }
                }
            }
        }
        
        return count;
    }
    
    private int getIndex(int i, int j, int col) {
        return i * col + j;
    }
}
