public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages == null) {
            throw new IllegalArgumentException();
        }
        
        int n = pages.length;
        int result = Integer.MIN_VALUE;
        
        if (n <= k) {
            for (int i = 0; i < n; i++) {
                result = Math.max(result, pages[i]);
            }
            
            return result;
        }
        
        int[][] sum = new int[n + 1][n + 1];
        int[][] rec = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {  
            for (int j = i; j <= n; j++) {  
                for (int x = i; x <= j; x++) {
                    sum[i][j] += pages[x - 1];  
                }
            } 
        }
        
        for (int i = 1; i <= n; i++)  {
            rec[i][1] = sum[1][i];
        }
        
        for (int x = 2; x <= k; x++) {
            for(int i = x; i <= n; i++) {
                rec[i][x] = Integer.MAX_VALUE;
                
                for (int j = 1; j < i; j++) {  
                    if(rec[i][x] > Math.max(rec[j][x - 1], sum[j + 1][i])) {
                        rec[i][x] = Math.max(rec[j][x - 1], sum[j + 1][i]);
                    }
                }  
            }
        }
        
        return rec[n][k];
    }
}
