class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = 0;
        
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (helper(piles, H, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean helper(int[] piles, int H, int K) {
        int time = 0;
        
        for (int pile : piles) {
            time += (pile - 1) / K + 1;
        }
        
        return time <= H;
    }
}
