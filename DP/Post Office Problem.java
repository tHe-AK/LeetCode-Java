public class Solution {
    /**
     * @param A an integer array
     * @param k an integer
     * @return an integer
     */
    public int postOffice(int[] A, int k) {
        if (A == null || k <= 0 || k >= A.length) {
            return 0;
        }
        
        int n = A.length;
        Arrays.sort(A);

        int[][] dis = new int[n + 1][n + 1];
        int[][] rec = new int[n + 1][k + 1];
        int result = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; i++) {  
            for(int j = i + 1; j <= n; j++) {  
                int mid = j + (i - j) / 2;
                
                for (int x = i; x <= j; x++) {
                    dis[i][j] += Math.abs(A[x - 1] - A[mid - 1]);  
                }
            } 
        }
        
        for(int i = 0; i <= n; i++) {
            rec[i][1] = dis[1][i];
        }
        
        for(int x = 2; x <= k; x++) {
            for(int i = x; i <= n; i++) {
                rec[i][x] = Integer.MAX_VALUE;
                
                for(int j = 0; j < i; j++) {  
                    if(rec[i][x] > rec[j][x - 1] + dis[j + 1][i]) {
                        rec[i][x] = rec[j][x - 1] + dis[j + 1][i];  
                    }  
                }  
            }
        }
        
        return rec[n][k];
    }
}
