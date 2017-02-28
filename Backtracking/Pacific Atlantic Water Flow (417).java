public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        int[][] delta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        
        for (int i = 0; i < row; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, pacific, delta);
            dfs(matrix, i, col - 1, Integer.MIN_VALUE, atlantic, delta);
        }
        
        for (int j = 0; j < col; j++) {
            dfs(matrix, 0, j, Integer.MIN_VALUE, pacific, delta);
            dfs(matrix, row - 1, j, Integer.MIN_VALUE, atlantic, delta);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[] { i, j });
                }
            }
        }

        return result;
    }

    private void dfs(int[][] matrix, int i, int j, int pre, boolean[][] visited, int[][] delta) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] < pre) {
            return;
        }
        
        visited[i][j] = true;

        for (int[] diff : delta) {
            dfs(matrix, i + diff[0], j + diff[1], matrix[i][j], visited, delta);
        }
    }
}

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        int[][] delta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            queue1.offer(new int[] { i, 0 });
            queue2.offer(new int[] { i, col - 1 });
            pacific[i][0] = true;
            atlantic[i][col - 1] = true;
        }
        
        for (int j = 0; j < col; j++) {                                                                                         queue1.offer(new int[] { 0, j });
            queue2.offer(new int[] { row - 1, j });
            pacific[0][j] = true;
            atlantic[row - 1][j] = true;
        }
        
        bfs(matrix, queue1, pacific, delta);
        bfs(matrix, queue2, atlantic, delta);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[] { i, j });
                }
            }
        }

        return result;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited, int[][] delta) {
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            int i = peek[0];
            int j = peek[1];
            
            for (int[] diff : delta) {
                int x = i + diff[0];
                int y = j + diff[1];
                
                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y] && matrix[x][y] >= matrix[i][j]) {
                    visited[x][y] = true;
                    queue.offer(new int[] { x, y });
                }
            }
        }
    }
}
