class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> map = new HashMap<>();
        
        for (String triple : allowed) {
            String key = triple.substring(0, 2);
            map.putIfAbsent(key, new HashSet<>());
            map.get(key).add(triple.charAt(2));
        }
        
        return dfs(bottom, 0, map, new HashSet<String>());
    }
    
    private boolean dfs(String bottom, int i, Map<String, Set<Character>> map, Set<String> visited) {
        if (bottom.length() == 1) {
            return true;
        }
        
        if (i == 0) {            
            if (visited.contains(bottom)) {
                return false;
            }
            
            visited.add(bottom);
        }
        
        String key = bottom.substring(i, i + 2);
        
        if (map.containsKey(key)) {
            for (Character ch : map.get(key)) {
                boolean isEnd = i == bottom.length() - 2;
                String str = bottom.substring(0, i) + ch + (isEnd ? "" : bottom.substring(i + 1));
                int idx = isEnd ? 0 : i + 1;

                if (dfs(str, idx, map, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
