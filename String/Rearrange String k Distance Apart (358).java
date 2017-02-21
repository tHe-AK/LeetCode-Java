public class Solution {
    public String rearrangeString(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < len; i++){
            int idx = findValidIdx(count, valid, i);
            
            if (idx == -1) {
                return "";
            }
            
            count[idx]--;
            valid[idx] = i + k;
            sb.append((char) ('a' + idx));
        }
        
        return sb.toString();
    }
    
    private int findValidIdx(int[] count, int[] valid, int curr) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > max && curr >= valid[i]) {
                max = count[i];
                idx = i;
            }
        }
        
        return idx;
   }
}
