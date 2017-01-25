public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = 0;
        int[] rec = new int[256];
        int start = 0;
        int end = 0;
        int count = 0;
        
        while (end < s.length()) {
            if (rec[s.charAt(end++)]++ == 0) {
                count++;
            }
            
            while (count > 2) {
                if (rec[s.charAt(start++)]-- == 1) {
                    count--;
                }
            }
            
            result = Math.max(result, end - start);
        }
        
        return result;
    }
}
