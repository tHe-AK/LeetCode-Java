public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        int len = s.length();
        boolean[][] rec = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            int low = i;
            int high = i;
            
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                rec[low][high] = true;
                low--;
                high++;
            }
            
            low = i - 1;
            high = i;
            
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                rec[low][high] = true;
                low--;
                high++;
            }
        }
        
        int[] result = new int[len + 1];
        
        for (int i = 0; i < len; i++) {
            result[i] = i;
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (rec[j][i]) {
                    result[i] = Math.min(result[i], j == 0 ? 0 : result[j - 1] + 1);
                }
            }
        }
        
        return result[len - 1];
    }
}