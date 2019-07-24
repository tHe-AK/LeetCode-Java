class Solution {
    public int numRookCaptures(char[][] board) {
        int[][] delta = new int[][] {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};
        int count = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    for (int[] diff : delta) {
                        count += helper(board, i, j, diff[0], diff[1]);
                    }
                }
            }
        }
        
        return count;
    }
    
    private int helper(char[][] board, int i, int j, int x, int y) {
        while (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] != 'B') {
            if (board[i][j] == 'p') {
                return 1;
            }
            
            i += x;
            j += y;
        }
        
        return 0;
    }
}
