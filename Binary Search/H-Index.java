public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null) {
            throw new IllegalArgumentException();
        }
        
        int len = citations.length;
        int[] rec = new int[len + 1];
        int sum = 0;
        
        for (int citation : citations) {
            if (citation > len) {
                rec[len]++;
            } else {
                rec[citation]++;
            }
        }
        
        for (int i = len; i > 0; i--) {
            sum += rec[i];
            
            if (sum >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
