class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int[][] res = new int[R * C][2];
        int k = 0;
        int[] idx = { r0, c0 };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(idx);
        boolean[][] visited = new boolean[R][C];
        visited[r0][c0] = true;
        res[k++] = idx;

        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            int i = peek[0];
            int j = peek[1];
            
            for (int[] diff : delta) {
                int x = i + diff[0];
                int y = j + diff[1];
                
                if (x >= 0 && x < R && y >= 0 && y < C && !visited[x][y]) {
                    idx = new int[] { x, y };
                    queue.offer(idx);
                    visited[x][y] = true;
                    res[k++] = idx;
                }
            }
        }
        
        return res;
    }
}
