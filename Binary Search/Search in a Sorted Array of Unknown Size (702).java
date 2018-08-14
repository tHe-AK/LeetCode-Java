class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 9999;
        int ERROR = ;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = reader.get(mid);
            
            if (val == Integer.MAX_VALUE || val > target) {
              high = mid - 1;
            } else if (val < target) {
              low = mid + 1;
            } else {
              return mid;
            }
        }

        return -1;
    }
}
