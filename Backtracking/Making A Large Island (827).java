class Solution {
    public int largestIsland(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[] { 0, 0 }));
        int max = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j, list.size(), delta);
                    max = Math.max(max, count);
                    list.add(count);
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> visited = new HashSet<>();
                    int sum = 1;
                    
                    for (int[] diff : delta) {
                        int x = i + diff[0];
                        int y = j + diff[1];
                        
                        if (isValid(grid, x, y) && grid[x][y] >= 2 && visited.add(grid[x][y])) {
                            sum += list.get(grid[x][y]);
                        }
                    }
                    
                    max = Math.max(max, sum);
                }
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j, int idx, int[][] delta) {
        if (!isValid(grid, i, j) || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = idx;
        int count = 1;
        
        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            count += dfs(grid, x, y, idx, delta);
        }
        
        return count;
    }
    
    private boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
