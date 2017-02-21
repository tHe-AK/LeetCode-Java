public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int len = envelopes.length;
        int[] rec = new int[len];
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            rec[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    rec[i] = Math.max(rec[i], rec[j] + 1);
                }
            }
            
            max = Math.max(max, rec[i]);
        }
        
        return max;
    }
}
