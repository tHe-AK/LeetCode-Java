public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null) {
            throw new IllegalArgumentException();
        }
        
        int level = 1;
        
        if (start.equals(end)) {
            return level;
        }

        Queue<String> queue = new LinkedList<String>();
        dict.remove(start);
        queue.add(start);
        
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                
                for (int j = 0; j < cur.length(); j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (cur.charAt(j) == k) {
                            continue;
                        }
                        
                        sb.setCharAt(j, k);
                        String word = sb.toString();
                        
                        if (word.equals(end)) {
                            return level;
                        }
                        
                        if (dict.contains(word)) {
                            dict.remove(word);
                            queue.offer(word);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
