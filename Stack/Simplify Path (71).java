public class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<String>();

        for (String str : path.split("/")) {
            if (str.equals("") || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.offerLast(str);
            }
        }
        
        StringBuilder sb = new StringBuilder();
            
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollFirst());
        }
            
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
