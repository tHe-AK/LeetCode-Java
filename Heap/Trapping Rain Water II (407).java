class Solution {
    class Cell {
        public int x;
        public int y;
        public int h;

        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        int vol = 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.h, b.h));
        
        for (int i = 0; i < row; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }
        
        for (int j = 0; j < col; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(row - 1, j, heightMap[row - 1][j]));
            visited[0][j] = true;
            visited[row - 1][j] = true;
        }
        
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!pq.isEmpty()) {
            Cell peek = pq.poll();
            
            for (int[] diff : delta) {
                int x = peek.x + diff[0];
                int y = peek.y + diff[1];
                
                if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                    pq.offer(new Cell(x, y, Math.max(peek.h, heightMap[x][y])));
                    visited[x][y] = true;
                    
                    if (peek.h > heightMap[x][y]) {
                        vol += peek.h - heightMap[x][y];
                    }
                }
            }
        }
        
        return vol;
    }
}
