public class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        
        int[] count = new int[1];
        helper(n, 0, new int[n], count);
        
        return count[0];
    }
    
    private void helper(int n, int row, int[] rec, int[] count) {
        if (row == n) {
            count[0]++;
            return;
        }
        
        for (int j = 0; j < n; j++) {
            int i;
            
            for (i = 0; i < row; i++) {
                if (rec[i] == j || row - i == Math.abs(j - rec[i])) {
                    break;
                }
            }
            
            if (i == row) {
                rec[row] = j;
                helper(n, row + 1, rec, count);
            }
        }
    }
}
