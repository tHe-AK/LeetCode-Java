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
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null) {
            throw new IllegalArgumentException();
        }
        
        int sum = 0;
        
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return sum;
        }
        
        int row = heightMap.length;
        int col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
            public int compare(Cell c1, Cell c2) {
                return c1.height - c2.height;
            }
        });
        
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
        
        int[][] delta = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            Cell peek = pq.poll();
            
            for (int i = 0; i < delta.length; i++) {
                int x = peek.x + delta[i][0];
                int y = peek.y + delta[i][1];
                
                if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                    pq.offer(new Cell(x, y, Math.max(peek.height, heightMap[x][y])));
                    visited[x][y] = true;
                    
                    if (peek.height > heightMap[x][y]) {
                        sum += peek.height - heightMap[x][y];
                    }
                }
            }
        }
        
        return sum;
    }
}
