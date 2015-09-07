public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null) {
            throw new IllegalArgumentException();
        }
        
        int len = citations.length;
        int low = 0;
        int high = len - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (len - mid <= citations[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return len - low;
    }
}
