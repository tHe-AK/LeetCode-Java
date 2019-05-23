class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 5 && isValid(grid, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isValid(int[][] grid, int i, int j) {
        boolean[] visited = new boolean[9];
        
        for (int x = i - 1; x <= i + 1; x++) {
            int sum = 0;
            
            for (int y = j - 1; y <= j + 1; y++) {
                if (grid[x][y] == 0 || grid[x][y] > 9 || visited[grid[x][y] - 1]) {
                    return false;
                }
                
                visited[grid[x][y] - 1] = true;
                sum += grid[x][y];
            }
            
            if (sum != 15) {
                return false;
            }
        }
        
        for (int y = j - 1; y <= j + 1; y++) {
            int sum = 0;
            
            for (int x = i - 1; x <= i + 1; x++) {
                sum += grid[x][y];
            }
            
            if (sum != 15) {
                return false;
            }
        }
        
        return grid[i - 1][j - 1] + grid[i + 1][j + 1] == 10 && grid[i + 1][j - 1] + grid[i - 1][j + 1] == 10;
    }
}
