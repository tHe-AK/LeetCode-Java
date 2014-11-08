public class Solution {
    public String simplifyPath(String path) {
        if (path == null) {
            throw new IllegalArgumentException();
        }
        
        int len = path.length();
        int i = 0;
        Stack<String> stack = new Stack<String>();
        String result = "";

        while (i < len) {
            int j = i + 1;
            
            while (j < len && path.charAt(j) != '/') {
                j++;
            }
            
            String cur = path.substring(i + 1, j);
            i = j;
            
            if (cur.equals("..") && !stack.empty()) {
                stack.pop();
                continue;
            }
            
            if (cur.length() != 0 && !cur.equals(".")) {
                stack.push(cur);
            }
        }
        
        if (stack.empty()) {
            return "/";
        }
        else {
            while (!stack.empty()) {
                result = "/" + stack.pop() + result;
            }
            
            return result;
        }
    }
}