public class Solution {
    public int mergeStone(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int len = num.length;
        int[][] rec = new int[len][len];
        int[][] sum = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum[i][j] = num[j];
                
                if (j > i) {
                    sum[i][j] += sum[i][j - 1];
                }
            }
        }
        
        for (int l = 1; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                rec[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    rec[i][j] = Math.min(rec[i][j], rec[i][k] + rec[k + 1][j]);
                }
                
                rec[i][j] += sum[i][j];
            }
        }
        
        return rec[0][len - 1];
    }
