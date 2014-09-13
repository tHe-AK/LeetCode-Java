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
        
        boolean flag = true;
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        visited.add(start);
        queue.offer(start);
        
        while (flag && !queue.isEmpty()) {
            int size = queue.size();
            Set<String> level = new HashSet<String>();
            
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                hashMap.put(cur, new ArrayList<String>());

                for (int j = 0; j < cur.length(); j++) {
                    StringBuilder sb = new StringBuilder(cur);
                            
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == sb.charAt(j)) {
                            continue;
                        }
                                
                        sb.setCharAt(j, k);
                        String word = sb.toString();
                                
                        if (word.equals(end)) {
                        	flag = false;
                        }
                        
                        if (dict.contains(word) && !visited.contains(word)) {
                            hashMap.get(cur).add(word);
                            level.add(word);
                        }
                    }
                }
            }
            
            for (String word : level) {               
                visited.add(word);
                queue.offer(word);
            }
        }
        
        if (flag) {
            return result;
        }
        
        List<String> cur = new ArrayList<String>();
        cur.add(start);
        helper(start, end, hashMap, cur, result);
        
        return result;
    }
    
    private void helper(String start, String end, HashMap<String, List<String>> hashMap, List<String> cur, List<List<String>> result) {
        if (start.equals(end)) {
            result.add(new ArrayList<String>(cur));
            return;
        }
        
        if (!hashMap.containsKey(start)) {
            return;
        }
        
        for (String word : hashMap.get(start)) {
            cur.add(word);
            helper(word, end, hashMap, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
