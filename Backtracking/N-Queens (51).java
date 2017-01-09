public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        
        dfs(n, board, 0, col, diag1, diag2, result);
        
        return result;
    }
    
    private void dfs(int n, char[][] board, int row, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> result) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            
            for (char[] str : board) {
                list.add(new String(str));
            }
            
            result.add(list);
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (!col[j] && !diag1[row + j] && !diag2[row - j + n]) {
                board[row][j] = 'Q';
                col[j] = diag1[row + j] = diag2[row - j + n] = true;
                dfs(n, board, row + 1, col, diag1, diag2, result);
                board[row][j] = '.';
                col[j] = diag1[row + j] = diag2[row - j + n] = false;
            }
        }
    }
}
