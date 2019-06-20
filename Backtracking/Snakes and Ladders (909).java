class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N * N];
        queue.offer(0);
        visited[0] = true;
        int step = 0;
        
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int peek = queue.poll();
                
                for (int j = 1; j <= 6 && peek + j < N * N; j++) {
                    int next = peek + j;
                    int x = getX(next, N);
                    int y = getY(next, N);
                    
                    if (board[x][y] > 0) {
                        next = board[x][y] - 1;
                    }
                    
                    if (next == N * N - 1) {
                        return step;
                    }
                    
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private int getX(int idx, int N) {
        return N - 1 - (idx / N);
    }
    
    private int getY(int idx, int N) {
        int y = idx % N;
        return (idx / N) % 2 == 0 ? y : N - 1 - y;
    }
}
