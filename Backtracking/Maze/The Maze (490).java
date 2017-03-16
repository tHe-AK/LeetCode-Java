public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		
        while (!queue.isEmpty()) {
            int[] peek = queue.poll();
            
            for (int[] diff : delta) {
                int[] next = Arrays.copyOf(peek, peek.length);
                
                while (isValid(maze, next, diff)) {
                    next[0] += diff[0];
                    next[1] += diff[1];
                }
                
                if (next[0] == destination[0] && next[1] == destination[1]) {
                    return true;
                }
                
                if (!visited[next[0]][next[1]]) {
                    queue.offer(next);
                    visited[next[0]][next[1]] = true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isValid(int[][] maze, int[] start, int[] diff) {
        int i = start[0] + diff[0];
        int j = start[1] + diff[1];
        
        return i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 0;
    }
}

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		
        return dfs(maze, start, destination, visited, delta);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited, int[][] delta) {
        int i = start[0];
        int j = start[1];
        
        if (visited[i][j]) {
            return false;
        }
        
        if (i == destination[0] && j == destination[1]) {
            return true;
        }
        
        visited[i][j] = true;
        
        for (int[] diff : delta) {
            int[] next = Arrays.copyOf(start, start.length);
            
            while (isValid(maze, next, diff)) {
                next[0] += diff[0];
                next[1] += diff[1];
            }
            
            if (dfs(maze, next, destination, visited, delta)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isValid(int[][] maze, int[] start, int[] diff) {
        int i = start[0] + diff[0];
        int j = start[1] + diff[1];
        
        return i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 0;
    }
}
