public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] rec = new int[len + 1];
        
        for (int c : citations) {
            rec[Math.min(c, len)]++;
        }
        
        for (int s = rec[len]; s < len; s += rec[len]) {
            len--;
        }
        
        return len;
    }
}
