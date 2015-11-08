public class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> rec = new HashMap<Character, Character>();
        rec.put('(', ')');
        rec.put('{', '}');
        rec.put('[', ']');
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (rec.containsKey(cur)) {
                stack.push(cur);
            }
            else if (!stack.empty() && cur == rec.get(stack.peek())) {
                stack.pop();
            }
            else {
                return false;
            }
        }
        
        return stack.empty();
    }
}