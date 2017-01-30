public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] delta = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, visited, 0, delta)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited, int start, int[][] delta) {
        if (start == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(start)) {
            return false;
        }
        
        
        visited[i][j] = true;
            
        for (int k = 0; k < delta.length; k++) {
            int x = i + delta[k][0];
            int y = j + delta[k][1];
                
            if (dfs(board, word, x, y, visited, start + 1, delta)) {
                return true;
            }
        }
            
        visited[i][j] = false;
        
        return false;
    }
}
