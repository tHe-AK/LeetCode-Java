public class Solution {
    public boolean canCross(int[] stones) {
        return dfs(stones, 0, 0, new HashSet<String>());
    }
    
    private boolean dfs(int[] stones, int start, int k, Set<String> visited) {
        if (visited.contains(start + " " + k)) {
            return false;
        }

        visited.add(start + " " + k);
        
        for (int i = start + 1; i < stones.length; i++) {
            int diff = stones[i] - stones[start];
            
            if (diff < k - 1) {
                continue;
            } else if (diff <= k + 1) {
                if (dfs(stones, i, diff, visited)) {
                    return true;
                }
            } else {
                return false;
            }
        }
        
        return start == stones.length - 1;
    }
}
