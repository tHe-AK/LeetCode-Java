public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < ppid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            map.putIfAbsent(parent, new HashSet<>());
            map.get(parent).add(child);
        }
        
        dfs(map, kill, res);
        return res;
    }
    
    private void dfs(Map<Integer, Set<Integer>> map, int id, List<Integer> res) {
        res.add(id);
        
        if (!map.containsKey(id)) {
            return;
        }
        
        for (Integer child : map.get(id)) {
            dfs(map, child, res);
        }
    }
}
