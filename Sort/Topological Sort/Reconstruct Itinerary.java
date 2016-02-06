public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null) {
            throw new IllegalArgumentException();
        }
        
        Map<String, Queue<String>> rec = new HashMap<String, Queue<String>>();
        
        for (String[] ticket : tickets) {
            rec.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>()).add(ticket[1]);
        }
        
        List<String> result = new LinkedList<String>();
        dfs(rec, "JFK", result);
        
        return result;
    }
    
    private void dfs(Map<String, Queue<String>> rec, String cur, List<String> result) {
        while (rec.containsKey(cur) && !rec.get(cur).isEmpty()) {
            dfs(rec, rec.get(cur).poll(), result);
        }
        
        result.add(0, cur);
    }
}
