public class Solution {
    public boolean canCross(int[] stones) {
        return dfs(stones, 0, 0, new boolean[stones.length][stones.length]);
    }
    
    private boolean dfs(int[] stones, int start, int k, boolean[][] visited) {
        if (start == stones.length - 1) {
            return true;
        }
        
        if (visited[start][k]) {
            return false;
        }

        visited[start][k] = true;
        
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
        
        return false;
    }
}
