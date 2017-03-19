public class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = key.length();
        int n = ring.length();
        int[][] dp = new int[m + 1][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, ring.length() - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        
        return dp[0][0] + key.length();
    }
}

public class Solution {
    public int findRotateSteps(String ring, String key) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        return dfs(ring, key, 0, 0, map) + key.length();
    }
    
    private int dfs(String ring, String key, int start, int idx, Map<Integer, Map<Integer, Integer>> map){
        if (idx == key.length()) {
            return 0;
        }
        
        if (map.containsKey(start) && map.get(start).containsKey(idx)) {
            return map.get(start).get(idx);
        }
        
        char ch = key.charAt(idx);
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == ch) {
                int diff = Math.abs(start - i);
                int step = Math.min(diff, ring.length() - diff);
                result = Math.min(result, step + dfs(ring, key, i, idx + 1, map));
            }
        }

        Map<Integer, Integer> val = map.getOrDefault(start, new HashMap<>());
        val.put(idx, result);
        map.put(start, val);
        
        return result;
    }
}
