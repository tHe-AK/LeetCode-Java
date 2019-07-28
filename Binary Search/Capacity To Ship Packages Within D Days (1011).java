class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int low = 0;
        int high = 0;
        
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isValid(weights, mid, D)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean isValid(int[] weights, int max, int D) {
        int count = 1;
        int curr = 0;
        
        for (int weight : weights) {            
            if (curr + weight > max) {
                count++;
                curr = 0;
            }
            
            curr += weight;
            
            if (count > D) {
                return false;
            }
        }
        
        return true;
    }
}
