public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return word == null || word.isEmpty() == true;
        }
        
        int x = board.length;
        int y = board[0].length;
        boolean[][] flag = new boolean[x][y];
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (helper(0, word, i, j, board, flag) == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(int index, String word, int i, int j, char[][] board, boolean[][] flag) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        
        if (flag[i][j] == false && board[i][j] == word.charAt(index)) {
            flag[i][j] = true;
            if (helper(index + 1, word, i - 1, j, board, flag) == true || helper(index + 1, word, i + 1, j, board, flag) == true || helper(index + 1, word, i, j - 1, board, flag) == true || helper(index + 1, word, i, j + 1, board, flag) == true) {
                return true;
            }
            flag[i][j] = false;
        }
        
        return false;
    }
}
