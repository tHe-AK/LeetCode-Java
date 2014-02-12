public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int x = board.length;
        int y = board[0].length;
        
        for (int i = 0; i < x; i++) {
            helper(board, i, 0);
            helper(board, i, y - 1);
        }
        
        for (int j = 0; j < y; j++) {
            helper(board, 0, j);
            helper(board, x - 1, j);
        }
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void helper(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            Queue<Integer> queue = new LinkedList<Integer>();
            int x = board.length;
            int y = board[0].length;
            queue.offer(i * y + j);
            board[i][j] = '+';
            
            while (queue.size() > 0) {
                int val = queue.poll();
                i = val / y;
                j = val % y;
                if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                    queue.offer((i - 1) * y + j);
                    board[i - 1][j] = '+';
                }
                if (i + 1 < x && board[i + 1][j] == 'O') {
                    queue.offer((i + 1) * y + j);
                    board[i + 1][j] = '+';
                }
                if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                    queue.offer(i * y + j - 1);
                    board[i][j - 1] = '+';
                }
                if (j + 1 < y && board[i][j + 1] == 'O') {
                    queue.offer(i* y + j + 1);
                    board[i][j + 1] = '+';
                }
            }
        }
    }
}
