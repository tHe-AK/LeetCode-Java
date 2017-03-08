public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        
        return dfs(maxChoosableInteger, desiredTotal, 0, new HashMap<Integer, Boolean>());
    }

    private boolean dfs(int max, int total, int state, Map<Integer, Boolean> map) {
        if (map.containsKey(state)) {
            return map.get(state);
        }
        
        for (int i = 1; i <= max; i++) {
            int mask = 1 << (i - 1);
            
            if ((state & mask) == 0) {
                if (i >= total || !dfs(max, total - i, state | mask, map)) {
                    map.put(state, true);
                    return true;
                }
            }
        }
        
        map.put(state, false);
        return false;
    }
}

public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        
        return dfs(desiredTotal, new int[maxChoosableInteger + 1], new HashMap<String, Boolean>());
    }

    private boolean dfs(int total, int[] visited, Map<String, Boolean> map) {
        String key = Arrays.toString(visited);
        
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                
                if (i >= total || !dfs(total - i, visited, map)) {
                    visited[i] = 0;
                    map.put(key, true);
                    return true;
                }
                
                visited[i] = 0;
            }
        }
        
        map.put(key, false);
        return false;
    }
}
