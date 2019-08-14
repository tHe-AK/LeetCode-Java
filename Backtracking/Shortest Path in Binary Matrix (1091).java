class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        
        if (grid[0][0] == 1 || grid[M - 1][N - 1] == 1) {
            return -1;
        }
        
        if (M == 1 && N == 1) {
            return 1;
        }
        
        int[][] delta = { { -1, 1 }, { -1, 0 }, { 1, -1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { -1, -1 }, { -1, 0 } };
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        grid[0][0] = 1;
        int step = 1;
        
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            
            while (size-- > 0) {
                int[] peek = queue.poll();
                int i = peek[0];
                int j = peek[1];
                
                for (int[] diff : delta) {
                    int x = i + diff[0];
                    int y = j + diff[1];
                    
                    if (x >= 0 && x < M && y >= 0 && y < N && grid[x][y] == 0 ) {
                        if (x == M - 1 && y == N - 1) {
                            return step;
                        }
                        
                        queue.offer(new int[] { x, y });
                        grid[x][y] = 1;
                    }
                }
            }
        }
        
        return -1;
    }
}
