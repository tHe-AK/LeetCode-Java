class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[] { 0, 0, grid[0][0] });
        visited[0][0] = true;
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            int i = peek[0];
            int j = peek[1];
            int height = peek[2];
            
            for (int[] diff : delta) {
                int x = i + diff[0];
                int y = j + diff[1];
                
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    int max = Math.max(height, grid[x][y]);
                    
                    if (x == m - 1 && y == n - 1) {
                        return max;
                    }
                    
                    queue.offer(new int[] { x, y, max });
                    visited[x][y] = true;
                }
            }
        }
        
        return -1;
    }
}
