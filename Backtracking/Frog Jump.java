public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            throw new IllegalArgumentException();
        }
        
        return helper(stones, new HashMap<Integer, Boolean>(), 0, 0);
    }
    
    private boolean helper(int[] stones, Map<Integer, Boolean> rec, int k, int start) {
        int key = (k << 11) | start; 
        
        if (rec.containsKey(key)) {
            return rec.get(key);
        }
        
        if (start == stones.length - 1) {
            rec.put(key, true);
            return true;
        }
        
        for (int i = start + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[start];
            
            if (gap < k - 1) {
                continue;
            } else if (gap <= k + 1) {
                if (helper(stones, rec, gap, i)) {
                    rec.put(key, true);
                    return true;
                }
            } else {
                break;
            }
        }
        
        rec.put(key, false);
        return false;
    }
}
