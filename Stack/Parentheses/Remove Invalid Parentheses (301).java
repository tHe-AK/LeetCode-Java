public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        boolean isFound = false;

        while (!queue.isEmpty()) {
            int len = queue.size();
            Set<String> visited = new HashSet<String>();
            
            for (int i = 0; i < len; i++) {
                String peek = queue.poll();
                
                if (isValid(peek)) {
                    isFound = true;
                    result.add(peek);
                }
                
                if (!isFound) {
                    for (int j = 0; j < peek.length(); j++) {
                        char ch = peek.charAt(j);
                            
                        if (ch == '(' || ch == ')') {
                            String str = peek.substring(0, j) + peek.substring(j + 1);
                                
                            if (visited.add(str)) {
                                queue.add(str);
                            }
                        }
                    }
                }
            }

            if (isFound) {
                break;
            }
        }
        
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                if (count-- == 0) {
                    return false;
                }
            }
        }
        
        return count == 0;
    }
}
