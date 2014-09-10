public class Solution {
    public int minCut(String s) {
        if (s == null) {
            return 0;
        }
        
        int len = s.length();
        boolean[][] rec = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                rec[left][right] = true;
                left--;
                right++;
            }
            
            left = i - 1;
            right = i;
            
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                rec[left][right] = true;
                left--;
                right++;
            }
        }
        
        int[] result = new int[len];
        
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
