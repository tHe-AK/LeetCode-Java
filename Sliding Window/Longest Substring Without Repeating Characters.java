public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        int start = -1;
        int[] rec = new int[256];
        
        for (int i = 0; i < 256; i++) {
            rec[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            start = Math.max(start, rec[cur] + 1);
            rec[cur] = i;
            result = Math.max(result, i - start + 1);
        }
        
        return result;
    }
}