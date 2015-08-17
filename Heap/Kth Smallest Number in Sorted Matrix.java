class Point {
    int x;
    int y;
    int val;
    
    Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || k < 1 || k > matrix.length * matrix[0].length) {
            throw new IllegalArgumentException();
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(row * col, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.val - p2.val;
            }    
        });
        
        for (int i = 0; i < row; i++) {
            pq.offer(new Point(i, 0, matrix[i][0]));
        }
        
        int count = 0;
        
        while (!pq.isEmpty()) {
            Point peek = pq.poll();
            count++;
            
            if (count == k) {
                return peek.val;
            }
            
            int x = peek.x;
            int y = peek.y + 1;
            
            if (y < col) {
                pq.offer(new Point(x, y, matrix[x][y]));
            }
        }
        
        throw new IllegalArgumentException();
    }
}
