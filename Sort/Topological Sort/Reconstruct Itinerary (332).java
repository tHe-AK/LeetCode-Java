public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<>());
            }
            
            map.get(ticket[0]).add(ticket[1]);
        }
        
        List<String> result = new ArrayList<String>();
        dfs(map, "JFK", result);
        Collections.reverse(result);
        
        return result;
    }
    
    private void dfs(Map<String, Queue<String>> map, String str, List<String> result) {
        while (map.containsKey(str) && !map.get(str).isEmpty()) {
            dfs(map, map.get(str).poll(), result);
        }
        
        result.add(str);
    }
}
