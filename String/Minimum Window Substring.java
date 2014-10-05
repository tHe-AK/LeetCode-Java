public class Solution {
    public String minWindow(String S, String T) {
        if (S == null || T == null) {
            throw new IllegalArgumentException();
        }
        
        int[] rec = new int[256];
        int[] cur = new int[256];

        for (int i = 0; i < T.length(); i++) {
            rec[T.charAt(i)]++;
        }
        
        int low = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        
        for (int high = 0; high < S.length(); high++) {
            int letter = S.charAt(high);
            
            if (rec[letter] == 0) {
                continue;
            }
            
            if (cur[letter] < rec[letter]) {
                count++;
            }
            
            cur[letter]++;
            
            if (count == T.length()) {
                while (rec[S.charAt(low)] == 0 || cur[S.charAt(low)] > rec[S.charAt(low)]) {
                    letter = S.charAt(low);
                    
                    if (cur[letter] > rec[letter]) {
                        cur[letter]--;
                    }
                    
                    low++;
                }
                
                if (high - low + 1 < min) {
                    min = high - low + 1;
                    result = S.substring(low, high + 1);
                }
            }
        }
        
        return result;
    }
}