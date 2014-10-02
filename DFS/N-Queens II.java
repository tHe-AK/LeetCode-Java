public class Solution {
    public int totalNQueens(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        int[] result = new int[1];
        
        helper(n, new int[n], 0, result);
        
        return result[0];
    }
    
    private void helper(int n, int[] rec, int cur, int[] result) {
        if (cur == n) {
            result[0]++;
            return;
        }
        
        for (int j = 0; j < n; j++) {
            int i;
            
            for (i = 0; i < cur; i++) {
                if (j == rec[i] || cur - i == Math.abs(j - rec[i])) {
                    break;
                }
            }
            
            if (i == cur) {               
                rec[cur] = j;
                helper(n, rec, cur + 1, result);
            }
        }
    }
}