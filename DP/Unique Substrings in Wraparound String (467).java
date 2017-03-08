public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] rec = new int[26];
        int curr = 0; 

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                curr++;
            } else {
                curr = 1;
            }
            
            int idx = p.charAt(i) - 'a';
            rec[idx] = Math.max(rec[idx], curr);
        }
        
        int sum = 0;
        
        for (int count : rec) {
            sum += count;
        }
        
        return sum;
    }
}
