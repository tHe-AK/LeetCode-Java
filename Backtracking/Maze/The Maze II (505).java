public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int[][] rec = new int[maze.length][maze[0].length];
        
        for (int i = 0; i < rec.length; i++) {
            Arrays.fill(rec[i], Integer.MAX_VALUE);
        }
        
        dfs(maze, destination, start[0], start[1], 0, rec, delta);
        
        return rec[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : rec[destination[0]][destination[1]];
    }
    
    private void dfs(int[][] maze, int[] hole, int i, int j, int count, int[][] rec, int[][] delta) {
        if (count >= rec[hole[0]][hole[1]] || count >= rec[i][j]) {
            return;
        }
        
        rec[i][j] = count;

        if (i == hole[0] && j == hole[1]) {
            return;
        }
        
        for (int k = 0; k < delta.length; k++) {
            int x = i;
            int y = j;
            int step = count;

            while (isValid(maze, x, y, delta[k])) {
                x += delta[k][0];
                y += delta[k][1];
                step++;
            }
            
            dfs(maze, hole, x, y, step, rec, delta);
        }
    }
    
    private boolean isValid(int[][] maze, int i, int j, int[] diff) {
        int x = i + diff[0];
        int y = j + diff[1];
        
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }
}
