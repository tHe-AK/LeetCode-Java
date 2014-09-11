public class Solution {
    public int longestIncreasingSubsequence(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        
        int len = num.length;
        int[] result = new int[len];
        
        for (int i = 0; i < len; i++) {
            result[i] = 1;
        }
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (num[j] <= num[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }
        
        int max = 1;
        
        for (int i = 0; i < len; i++) {
            max = Math.max(max, result[i]);
        }
        
        return max;
    }
}
