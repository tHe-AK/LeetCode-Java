public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (String str : path.split("/")) {
            if (str.equals("") || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        
        StringBuilder sb = new StringBuilder();
            
        for (String str : stack) {
            sb.append("/").append(str);
        }
            
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
