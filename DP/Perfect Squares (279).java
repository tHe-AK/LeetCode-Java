public class Solution {
    public int numSquares(int n) {
        int[] rec = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            rec[i] = 4;

            for (int j = 1; j * j <= i; j++) {
                rec[i] = Math.min(rec[i], rec[i - j * j] + 1);
            }
        }
        
        return rec[n];
    }
}

public class Solution {
    public int numSquares(int n) {
        int[] result = new int[1];
        result[0] = 4;
        
        dfs(n, 1, 0, result);
        
        return result[0];
    }
    
    private void dfs(int n, int start, int count, int[] result) {
        if (count >= result[0]) {
            return;
        }
        
        if (n == 0) {
            result[0] = Math.min(result[0], count);
            return;
        }
    
        for (int i = start; i * i <= n; i++) {
            dfs(n - i * i, i, count + 1, result);
        }
    }
}
