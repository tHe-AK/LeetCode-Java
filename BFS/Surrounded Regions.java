public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            searchHelper(board, i, 0);
            searchHelper(board, i, col - 1);
        }
        
        for (int j = 0; j < col; j++) {
            searchHelper(board, 0, j);
            searchHelper(board, row - 1, j);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void searchHelper(char[][] board, int x, int y) {
        if (validHelper(board, x, y)) {
            int row = board.length;
            int col = board[0].length;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(x * col + y);
            board[x][y] = '+';
            
            while (!queue.isEmpty()) {
                int peek = queue.poll();
                int i = peek / col;
                int j = peek % col;
                
                if (validHelper(board, i - 1, j)) {
                    queue.offer((i - 1) * col + j);
                    board[i - 1][j] = '+';
                }
                
                if (validHelper(board, i + 1, j)) {
                    queue.offer((i + 1) * col + j);
                    board[i + 1][j] = '+';
                }
                
                if (validHelper(board, i, j - 1)) {
                    queue.offer(i * col + j - 1);
                    board[i][j - 1] = '+';
                }
                
                if (validHelper(board, i, j + 1)) {
                    queue.offer(i * col + j + 1);
                    board[i][j + 1] = '+';
                }
            }
        }
    }
    
    private boolean validHelper(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return false;
        }
        else {
            return true;
        }
    }
}