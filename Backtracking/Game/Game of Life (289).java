public class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        int[][] delta = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                
                for (int[] diff : delta) {
                    int x = i + diff[0];
                    int y = j + diff[1];
                    
                    if (x >= 0 && x < row && y >= 0 && y < col && (board[x][y] == 1 || board[x][y] == 2)) {
                        count++;
                    }
                }
                
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
