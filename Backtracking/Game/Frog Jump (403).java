class Solution {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        
        map.get(0).add(0);
        
        for (int i = 0; i < len; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        
        return map.get(stones[len - 1]).size() > 0;
    }
}

class Solution {
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
                break;
            }
        }
        
        return false;
    }
}

public class Solution {
    public boolean canCross(int[] stones) {
        return dfs(stones, 0, 0, new HashSet<String>());
    }
    
    private boolean dfs(int[] stones, int start, int k, Set<String> visited) {
        if (start == stones.length - 1) {
            return true;
        }
        
        String key = start + " " + k; 
        
        if (visited.contains(key)) {
            return false;
        }
        
        for (int i = start + 1; i < stones.length; i++) {
            int diff = stones[i] - stones[start];
            
            if (diff < k - 1) {
                continue;
            } else if (diff <= k + 1) {
                if (dfs(stones, i, diff, visited)) {
                    return true;
                }
            } else {
                break;
            }
        }
        
        visited.add(key);
        return false;
    }
}

public class Solution {
    public boolean canCross(int[] stones) {
        return dfs(stones, 0, 0, new HashSet<Integer>());
    }
    
    private boolean dfs(int[] stones, int start, int k, Set<Integer> visited) {
        if (start == stones.length - 1) {
            return true;
        }
        
        int key = (k << 11) | start; 
        
        if (visited.contains(key)) {
            return false;
        }
        
        for (int i = start + 1; i < stones.length; i++) {
            int diff = stones[i] - stones[start];
            
            if (diff < k - 1) {
                continue;
            } else if (diff <= k + 1) {
                if (dfs(stones, i, diff, visited)) {
                    return true;
                }
            } else {
                break;
            }
        }
        
        visited.add(key);
        return false;
    }
}
