public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            throw new IllegalArgumentException();
        }
        
        return helper(stones, 0, 0);
    }
    
    private boolean helper(int[] stones, int k, int start) {
        if (start == stones.length - 1) {
            return true;
        }
        
        for (int i = start + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[start];
            
            if (gap < k - 1) {
                continue;
            } else if (gap <= k + 1) {
                if (helper(stones, gap, i)) {
                    return true;
                }
            } else {
                break;
            }
        }
        
        return false;
    }
}
