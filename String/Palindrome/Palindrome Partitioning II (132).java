public class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] rec = new boolean[len][len];
        int[] result = new int[len];
        
        for (int i = 0; i < len; i++) {
            isPalindrome(s, rec, i, i);
            isPalindrome(s, rec, i, i + 1);
        }
        
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
    
    private void isPalindrome(String s, boolean[][] rec, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            rec[low][high] = true;
            low--;
            high++;
        }
    }
}
