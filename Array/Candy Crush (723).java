class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean todo = false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j + 2 < n; j++) {
                int val = Math.abs(board[i][j]);
                
                if (val != 0 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])) {
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -val;
                    todo = true;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i + 2 < m; i++) {
                int val = Math.abs(board[i][j]);

                if (val != 0 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])) {
                    board[i][j] = board[i + 1][j] = board[i + 2][j] = -val;
                    todo = true;
                }
            }
        }
        
        if (todo) {
        	for (int j = 0; j < n; j++) {
                int k = m - 1;
                
                for (int i = m - 1; i >= 0; i--) {
                	if (board[i][j] > 0) {
                		board[k--][j] = board[i][j];
                	}
                }
                
                while (k >= 0) {
                	board[k--][j] = 0;
                }
            }
        	
        	return candyCrush(board);
        } else {
        	return board;
        }
    }
}
