class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        int[] rec = new int[envelopes.length];
        int len = 0;

        for (int[] envelope : envelopes) {
            int idx = Arrays.binarySearch(rec, 0, len, envelope[1]);
            
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            rec[idx] = envelope[1];
            
            if (idx == len) {
                len++;
            }
        }
        
        return len;
    }
}

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> Integer.compare(a[0], b[0]));
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
