public class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        String[] result = new String[1];
        int[][] rec = new int[maze.length][maze[0].length];
        String[] dir = { "u", "d", "l", "r" };
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        
        for (int i = 0; i < rec.length; i++) {
            Arrays.fill(rec[i], Integer.MAX_VALUE);
        }
		
        dfs(maze, hole, ball[0], ball[1], 0, min, "", result, rec, dir, delta);
        
        return result[0] == null ? "impossible" : result[0];
    }
    
    private void dfs(int[][] maze, int[] hole, int i, int j, int count, int[] min, String curr, String[] result, int[][] rec, String[] dir, int[][] delta) {
        if (count > min[0] || count > rec[i][j]) {
            return;
        }

        for (int k = 0; k < delta.length; k++) {
            int x = i;
            int y = j;
            int step = count;
            String path = curr + dir[k];

            while (isValid(maze, x, y, delta[k])) {
                step++;
                x += delta[k][0];
                y += delta[k][1];
                rec[x][y] = Math.min(rec[x][y], step);
                        
                if (x == hole[0] && y == hole[1] && step <= min[0]) {
                    if (step < min[0]) {
                        min[0] = step;
                        result[0] = path;
                    } else if (path.compareTo(result[0]) < 0) {
                        result[0] = path;
                    }
                        
                    return;
                }
            }
            
            if (step > count) {
                dfs(maze, hole, x, y, step, min, path, result, rec, dir, delta);
            }
        }
    }
    
    private boolean isValid(int[][] maze, int i, int j, int[] diff) {
        int x = i + diff[0];
        int y = j + diff[1];
        
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }
}
