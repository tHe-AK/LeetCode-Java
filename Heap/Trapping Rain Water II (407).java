class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        int vol = 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        
        for (int i = 0; i < row; i++) {
            pq.offer(new int[] { i, 0, heightMap[i][0] });
            pq.offer(new int[] { i, col - 1, heightMap[i][col - 1] });
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }
        
        for (int j = 0; j < col; j++) {
            pq.offer(new int[] { 0, j, heightMap[0][j] });
            pq.offer(new int[] { row - 1, j, heightMap[row - 1][j] });
            visited[0][j] = true;
            visited[row - 1][j] = true;
        }
        
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!pq.isEmpty()) {
            int[] peek = pq.poll();
            
            for (int[] diff : delta) {
                int x = peek[0] + diff[0];
                int y = peek[1] + diff[1];
                
                if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                    pq.offer(new int[] { x, y, Math.max(peek[2], heightMap[x][y]) });
                    visited[x][y] = true;
                    
                    if (peek[2] > heightMap[x][y]) {
                        vol += peek[2] - heightMap[x][y];
                    }
                }
            }
        }
        
        return vol;
    }
}
