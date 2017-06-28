public class Solution {
    public void solveSudoku(char[][] board) {
        int N = 9;
        boolean[][] row = new boolean[N][N];
        boolean[][] col = new boolean[N][N];
        boolean[][] sq = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '1';
                    int k = i / 3 * 3 + j / 3;
                    row[i][val] = col[j][val] = sq[k][val] = true;
                }
            }
        }
        
        dfs(board, row, col, sq);
    }
    
    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] sq) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int k = i / 3 * 3 + j / 3;

                    for (int val = 0; val < 9; val++) {
                        if (!row[i][val] && !col[j][val] && !sq[k][val]) {
                            board[i][j] = (char)('1' + val);
                            row[i][val] = col[j][val] = sq[k][val] = true;
                            
                            if (dfs(board, row, col, sq)) {
                                return true;
                            }
                            
                            board[i][j] = '.';
                            row[i][val] = col[j][val] = sq[k][val] = false;
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
}

public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }
    
    private boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9.; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (dfs(board)) {
                                return true;
                            }
                            
                            board[i][j] = '.';
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        
        int x = (row / 3) * 3;
        int y = (col / 3) * 3;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
                    
        return true;
    }
}
