public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] index = new int[256];
        int start = 0;
        int end = 0;
        
        while (end < s.length()) {
            char c = s.charAt(end);
            start = Math.max(index[c], start);
            result = Math.max(result, end - start + 1);
            index[c] = ++end;
        }
        
        return result;
    }
}
