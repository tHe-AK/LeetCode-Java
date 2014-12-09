public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int low = 0;
        int high = num.length - 1;
        
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            
            if (num[low] < num[high]) {
                return num[low];
            }
            else if (num[low] <= num[mid]) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        
        return Math.min(num[low], num[high]);
    }
}

