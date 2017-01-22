public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        int[][] delta = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0, delta);
            dfs(board, i, col - 1, delta);
        }
        
        for (int j = 0; j < col; j++) {
            dfs(board, 0, j, delta);
            dfs(board, row - 1, j, delta);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j, int[][] delta) {
        if (board[i][j] != 'O') {
            return;
        }
        
        board[i][j] = '+';
            
        for (int[] diff : delta) {
            int x = i + diff[0];
            int y = j + diff[1];
            
            if (x >= 0 && x < board.length && y > 0 && y < board[0].length) {
                dfs(board, x, y, delta);
            }
        }
    }
}
