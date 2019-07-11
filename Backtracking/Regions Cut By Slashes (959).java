class Solution {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int[][] board = new int[3 * N][3 * N];
        int count = 0;
        int[][] delta = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char ch = grid[i].charAt(j);
                
                if (ch == '/') {
                    board[i * 3][j * 3 + 2] = board[i * 3 + 1][j * 3 + 1] = board[i * 3 + 2][j * 3] = 1;
                } else if (ch == '\\') {
                    board[i * 3][j * 3] = board[i * 3 + 1][j * 3 + 1] = board[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    dfs(board, i, j, delta);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] board, int i, int j, int[][] delta) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 1) {
            return;
        }
        
        board[i][j] = 1;
        
        for (int[] diff : delta) {
            dfs(board, i + diff[0], j + diff[1], delta);
        }
    }
}
