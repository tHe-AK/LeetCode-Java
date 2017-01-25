public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int result = 0;
        int start = 0;
        int count = 0;
        int[] rec = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i);
            
            if (rec[cur] == 0) {
                count++;
            }
            
            rec[cur]++;
            
            while (count > 2) {
                cur = s.charAt(start);
                rec[cur]--;
                
                if (rec[cur] == 0) {
                    count--;
                }
                
                start++;
            }

            result = Math.max(result, i - start + 1);
        }
        
        return result;
    }
}
