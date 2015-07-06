import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

class Point {
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    List<Point> continentalDivider(int[][] matrix) {
        List<Point> result = new ArrayList<Point>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        BitSet[][] rec = new BitSet[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rec[i][j] = new BitSet(4);
            }
        }
        
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            helper(matrix, i, 0, 0, visited, rec, 0);
        }
        
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            helper(matrix, i, col - 1, 0, visited, rec, 1);
        }
        
        visited = new boolean[row][col];
        for (int j = 0; j < col; j++) {
            helper(matrix, 0, j, 0, visited, rec, 2);
        }
        
        visited = new boolean[row][col];
        for (int j = 0; j < col; j++) {
            helper(matrix, row - 1, j, 0, visited, rec, 3);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rec[i][j].get(0) && rec[i][j].get(1) && rec[i][j].get(2) && rec[i][j].get(3)) {
                    result.add(new Point(i, j));
                }
            }
        }

        return result;
    }

    private void helper(int[][] matrix, int i, int j, int pre, boolean[][] visited, BitSet[][] rec, int type) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] < pre) {
            return;
        }
        
        visited[i][j] = true;
        rec[i][j].set(type);
        
        helper(matrix, i - 1, j, matrix[i][j], visited, rec, type);
        helper(matrix, i + 1, j, matrix[i][j], visited, rec, type);
        helper(matrix, i, j - 1, matrix[i][j], visited, rec, type);
        helper(matrix, i, j + 1, matrix[i][j], visited, rec, type);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        int[][] matrix = new int[][] {{0, 0, 0, 1, 2, 3, 0}, {0, 1, 2, 2, 4, 3, 2}, {2, 1, 1, 3, 3, 2, 0}, {0, 3, 3, 3, 2, 3, 3}};
        for (Point p : s.continentalDivider(matrix)) {
            System.out.println(p.x + "," + p.y);
        }
    }
}
