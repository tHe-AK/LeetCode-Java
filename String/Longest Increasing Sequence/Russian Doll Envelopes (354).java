public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        int[] rec = new int[envelopes.length];
        int len = 0;

        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(rec, 0, len, envelope[1]);
            
            if (index < 0) {
                index = -(index + 1);
            }
            
            rec[index] = envelope[1];
            
            if (index == len) {
                len++;
            }
        }
        
        return len;
    }
}

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
