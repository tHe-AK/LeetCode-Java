public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        boolean found = false;
        List<String> result = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);

        while (!queue.isEmpty()) {
            int len = queue.size();
            Set<String> visited = new HashSet<String>();
            
            for (int i = 0; i < len; i++) {
                String peek = queue.poll();
                
                if (valid(peek)) {
                    found = true;
                    result.add(peek);
                }
                
                for (int j = 0; j < peek.length(); j++) {
                    char c = peek.charAt(j);
                        
                    if (c == '(' || c == ')') {
                        String str = peek.substring(0, j) + peek.substring(j + 1);
                            
                        if (!visited.contains(str)) {
                            visited.add(str);
                            queue.add(str);
                        }
                    }
                }
            }

            if (found) {
                break;
            }
        }
        
        return result;
    }
    
    private boolean valid(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                count++;
            }
            
            if (c == ')') {
                if (count <= 0) {
                    return false;
                }
                
                count--;
            }
        }
        
        return count == 0;
    }
}
