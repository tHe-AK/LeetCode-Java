public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        
        dfs(s, left, right, new HashSet<String>(), result);
        
        return result;
    }
    
    private void dfs(String s, int left, int right, Set<String> visited, List<String> result) {
        if (!visited.add(s)) {
            return;
        }
        
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' && left > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), left - 1, right, visited, result);
            } else if (ch == ')' && right > 0) {
                dfs(s.substring(0, i) + s.substring(i + 1), left, right - 1, visited, result);
            }
        }
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
