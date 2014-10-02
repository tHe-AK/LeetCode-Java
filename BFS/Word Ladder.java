public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null) {
            throw new IllegalArgumentException();
        }
        
        int len = 1;
        
        if (start.equals(end)) {
            return len;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String peek = queue.poll();
                
                for (int j = 0; j < peek.length(); j++) {
                    StringBuilder sb = new StringBuilder(peek);
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String cur = sb.toString();
                        
                        if (cur.equals(end)) {
                            return len;
                        }
                        
                        if (dict.contains(cur)) {
                            queue.offer(cur);
                            dict.remove(cur);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}