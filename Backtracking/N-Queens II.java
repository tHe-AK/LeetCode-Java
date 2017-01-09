public class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1];
        
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        
        dfs(n, 0, col, diag1, diag2, count);
        
        return count[0];
    }
    
    private void dfs(int n, int row, boolean[] col, boolean[] diag1, boolean[] diag2, int[] count) {
        if (row == n) {
            count[0]++;
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (!col[j] && !diag1[row + j] && !diag2[row - j + n]) {
                col[j] = diag1[row + j] = diag2[row - j + n] = true;
                dfs(n, row + 1, col, diag1, diag2, count);
                col[j] = diag1[row + j] = diag2[row - j + n] = false;
            }
        }
    }
}
