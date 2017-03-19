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
