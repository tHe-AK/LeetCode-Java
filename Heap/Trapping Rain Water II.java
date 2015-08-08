class Cell {
    int x;
    int y;
    int height;
    
    Cell(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}

public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        int sum = 0;
        
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return sum;
        }
        
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(row * col, new Comparator<Cell>() {
            public int compare(Cell c1, Cell c2) {
                return c1.height - c2.height;
            }
        });
        
        for (int i = 0; i < row; i++) {
            pq.offer(new Cell(i, 0, heights[i][0]));
            pq.offer(new Cell(i, col - 1, heights[i][col - 1]));
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }
        
        for (int j = 0; j < col; j++) {
            pq.offer(new Cell(0, j, heights[0][j]));
            pq.offer(new Cell(row - 1, j, heights[row - 1][j]));
            visited[0][j] = true;
            visited[row - 1][j] = true;
        }
        
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        
        while (!pq.isEmpty()) {
            Cell peek = pq.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = peek.x + dx[i];
                int y = peek.y + dy[i];
                
                if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                    pq.offer(new Cell(x, y, Math.max(peek.height, heights[x][y])));
                    visited[x][y] = true;
                    
                    if (peek.height > heights[x][y]) {
                        sum += peek.height - heights[x][y];
                    }
                }
            }
        }
        
        return sum;
    }
};
