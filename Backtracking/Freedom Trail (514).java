public class Solution {
    public int findRotateSteps(String ring, String key) {
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        
        return dfs(ring, key, 0, map) + key.length();
    }
    
    private int dfs(String ring, String key, int idx, Map<String, Map<Integer, Integer>> map){
        if (idx == key.length()) {
            return 0;
        }
        
        if (map.containsKey(ring) && map.get(ring).containsKey(idx)) {
            return map.get(ring).get(idx);
        }
        
        char ch = key.charAt(idx);
        int clockIdx = ring.indexOf(ch);
        int antiIdx = getAntiIdx(ring, ch);
        
        int clock = clockIdx + dfs(ring.substring(clockIdx) + ring.substring(0, clockIdx), key, idx + 1, map);
        int anti = ring.length() - antiIdx + dfs(ring.substring(antiIdx) + ring.substring(0, antiIdx), key, idx + 1, map);
        int result = Math.min(clock, anti);
        
        Map<Integer, Integer> val = map.getOrDefault(ring, new HashMap<>());
        val.put(idx, result);
        map.put(ring, val);
        
        return result;
    }
    
    private int getAntiIdx(String ring, char ch) {
        if (ring.charAt(0) == ch) {
            return 0;
        } else {
            for (int i = ring.length() - 1; i > 0; i--) {
                if (ring.charAt(i) == ch) {
                    return i;
                }
            }
            
            return -1;
        }
    }
}
