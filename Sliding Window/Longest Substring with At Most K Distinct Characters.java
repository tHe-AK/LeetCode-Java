public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
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
            
            while (count > k) {
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
