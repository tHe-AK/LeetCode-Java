public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            throw new IllegalArgumentException();
        }
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] rec = new boolean[row][col];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, rec, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j, boolean[][] rec, int start) {
        if (start == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        
        if (board[i][j] == word.charAt(start) && !rec[i][j]) {
            rec[i][j] = true;
            
            if (helper(board, word, i - 1, j, rec, start + 1) || helper(board, word, i + 1, j, rec, start + 1) || helper(board, word, i, j - 1, rec, start + 1) || helper(board, word, i, j + 1, rec, start + 1)) {
                return true;
            }
            
            rec[i][j] = false;
        }
        
        return false;
    }
}