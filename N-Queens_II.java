public class Solution {
    
    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        int[] rec = new int[n];
        int[] count = new int[1];
        count[0] = 0;
        helper(0, rec, count);
        
        return count[0];
    }
    
    private void helper(int row, int[] rec, int[] count) {
        if (row == rec.length) {
            count[0]++;
            return;
        }
        
        for (int i = 0; i < rec.length; i++) {
            if (valid(row, i, rec)) {
                rec[row] = i;
                helper(row + 1, rec, count);
            }
        }
    }
    
    private boolean valid(int row, int col, int[] rec) {
        for (int i = 0; i < row; i++) {
            if (rec[i] == col || row - i == Math.abs(col - rec[i])) {
                return false;
            }
        }
        
        return true;
    }
}
