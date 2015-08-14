public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        
        int max = 0;
        int x = A.length;
        int y = A[0].length;
        int[][] rec = new int[x][y];
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                max = Math.max(max, helper(A, rec, dx, dy, i, j));
            }
        }
        
        return max;
    }
    
    private int helper(int[][] A, int[][] rec, int[] dx, int[] dy, int i, int j) {
        if (rec[i][j] > 0) {
            return rec[i][j];
        }
        
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            
            if (x >= 0 && y >= 0 && x < A.length && y < A[0].length && A[x][y] > A[i][j]) {
                rec[i][j] = Math.max(rec[i][j], helper(A, rec, dx, dy, x, y));
            }
        }
        
        rec[i][j]++;
        
        return rec[i][j];
    }
}
