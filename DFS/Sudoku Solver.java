public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException();
        }
        
        helper(board);
    }
    
    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9.; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (valid(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (helper(board)) {
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
    
    private boolean valid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == c) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if (board[x][j] == c) {
                return false;
            }
        }

        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
                    
        return true;
    }
}
