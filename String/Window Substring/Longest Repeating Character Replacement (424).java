public class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int[] rec = new int[256];
        int start = 0;
        int end = 0;
        int count = 0;
        
        while (end < s.length()) {
            count = Math.max(count, ++rec[s.charAt(end++)]);

            while (end - start - count > k) {
                rec[s.charAt(start++)]--;
            }
            
            result = Math.max(result, end - start);
        }
        
        return result;
    }
}
