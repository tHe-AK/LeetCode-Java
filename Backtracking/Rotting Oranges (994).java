class Solution {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * N + j);
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        
        if (count == 0) {
            return 0;
        }
        
        int step = -1;
        
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            
            while (size-- > 0) {
                int peek = queue.poll();
                int i = peek / N;
                int j = peek % N;
                
                for (int[] diff : delta) {
                    int x = i + diff[0];
                    int y = j + diff[1];
                    
                    if (x >= 0 && x < M && y >= 0 && y < N && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        count--;
                        queue.offer(x * N + y);
                    }
                }
            }
        }
        
        return count > 0 ? -1 : step;
    }
}
