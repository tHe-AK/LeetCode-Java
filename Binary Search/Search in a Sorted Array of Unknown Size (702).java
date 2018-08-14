class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 9999;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = reader.get(mid);
            
            if (val == target) {
              return mid;
            } else if (val < target) {
              low = mid + 1;
            } else {
              high = mid - 1;
            }
        }

        return -1;
    }
}
