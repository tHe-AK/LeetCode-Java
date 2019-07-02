class Solution {
    public int shortestBridge(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int[][] delta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        boolean[][] visited = new boolean[M][N];
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        
        loop: for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, delta, visited, queue);
                    break loop;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                int peek = queue.poll();
                int i = peek / N;
                int j = peek % N;
                
                for (int[] diff : delta) {
                    int x = i + diff[0];
                    int y = j + diff[1];
                    
                    if (x >= 0 && x < A.length && y >= 0 && y < A[0].length && !visited[x][y]) {
                        if (A[x][y] == 1) {
                            return res;
                        }
                        
                        visited[x][y] = true;
                        queue.offer(x * N + y);
                    }
                }
            }
            
            res++;
        }
        
        return -1;
    }
    
    private void dfs(int[][] A, int i, int j, int[][] delta, boolean[][] visited, Queue<Integer> queue) {
        if (visited[i][j]) {
            return;
        }
                
        visited[i][j] = true;
        boolean isBorder = false;
        
        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            

            if (x >= 0 && x < A.length && y >= 0 && y < A[0].length) {
                if (A[x][y] == 1) {
                    dfs(A, x, y, delta, visited, queue);
                } else {
                    isBorder = true;
                }
            }
        }
        
        if (isBorder) {
            queue.offer(i * A[0].length + j);
        }
    }
}
