public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        boolean[][] row = new boolean[N][N];
        boolean[][] col = new boolean[N][N];
        boolean[][] sq = new boolean[N][N];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int k = i / 3 * 3 + j / 3;
                    
                    if (row[i][num] || col[j][num] || sq[k][num]) {
                        return false;
                    } else {
                        row[i][num] = col[j][num] = sq[k][num] = true;
                    }
                }
            }
        }
        
        return true;
    }
}
