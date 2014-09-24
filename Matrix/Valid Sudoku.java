public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            throw new IllegalArgumentException();
        }

        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        
        int len = 9;
        boolean[][] row = new boolean[len][len];
        boolean[][] col = new boolean[len][len];
        boolean[][] sq = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '1';
                    
                    if (row[i][val]) {
                        return false;
                    }
                    row[i][val] = true;
                    
                    if (col[j][val]) {
                        return false;
                    }
                    col[j][val] = true;
                    
                    if (sq[i / 3 * 3 + j / 3][val]) {
                        return false;
                    }
                    sq[i / 3 * 3 + j / 3][val] = true;
                }
            }
        }
        
        return true;        
    }
}