public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty() == true || s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            }
            else {
                if (stack.empty() == true) {
                    return false;
                }
                else if (stack.peek() == hashMap.get(cur)) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        
        return stack.empty() == true;
    }
}
