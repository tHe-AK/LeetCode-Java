public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null) {
            throw new IllegalArgumentException();
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        if (start.equals(end)) {
            List<String> path = new ArrayList<String>();
            path.add(start);
            result.add(path);
            return result;
        }

        Queue<String> queue = new LinkedList<String>();
        HashMap<String, List<String>> rec = new HashMap<String, List<String>>();
        HashSet<String> visited = new HashSet<String>();
        boolean flag = false;
        queue.offer(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            HashSet<String> level = new HashSet<String>();
            
            for (int i = 0; i < size; i++) {
                String peek = queue.poll();
                List<String> value = new ArrayList<String>();
                
                for (int j = 0; j < peek.length(); j++) {
                    StringBuilder sb = new StringBuilder(peek);
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String cur = sb.toString();
                        
                        if (cur.equals(end)) {
                            flag = true;
                        }
                        
                        if (dict.contains(cur) && !visited.contains(cur)) {
                            value.add(cur);
                            level.add(cur);
                        }
                    }
                }
                
                rec.put(peek, value);
            }
            
            if (flag) {
                break;
            }
            else {
                for (String word : level) {
                    queue.offer(word);
                    visited.add(word);
                }
            }
        }
        
        List<String> cur = new ArrayList<String>();
        cur.add(start);
        helper(start, end, rec, cur, result);
        
        return result;
    }
    
    private void helper(String start, String end, HashMap<String, List<String>> rec, List<String> cur, List<List<String>> result) {
        if (start.equals(end)) {
            result.add(new ArrayList<String>(cur));
            return;
        }
   
        if (!rec.containsKey(start)) {
            return;
        }
           
        for (String word : rec.get(start)) {
            cur.add(word);
            helper(word, end, rec, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}