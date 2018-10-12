class Solution {
    public int movesToChessboard(int[][] board) {
        int N = board.length;
        int rowCount = 0;
        int colCount = 0;
        int rowSwap = 0;
        int colSwap = 0;
            
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) != 0) {
                    return -1;
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            rowCount += board[0][i];
            colCount += board[i][0];
            
            if (board[0][i] != i % 2) {
                rowSwap++;
            }
            
            if (board[i][0] != i % 2) {
                colSwap++;
            }
        }
        
        if (Math.abs(N - 2 * rowCount) > 1 || Math.abs(N - 2 * colCount) > 1) {
            return -1;
        }
        
        if (N % 2 == 0) {
            rowSwap = Math.min(rowSwap, N - rowSwap);
            colSwap = Math.min(colSwap, N - colSwap);
        } else {
            if (rowCount > N / 2) {
                rowSwap = N - rowSwap;
            }

            if (colCount > N / 2) {
                colSwap = N - colSwap;
            }
        }
        
        return (rowSwap + colSwap) / 2;
    }
}
