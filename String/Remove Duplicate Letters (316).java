class Solution {
    public String removeDuplicateLetters(String s) {
        String result = "";
        
        while (s.length() > 0) {
            int len = s.length();
            int[] rec = new int[26];
            int idx = 0;
            
            for (int i = 0; i < len; i++) {
                rec[s.charAt(i) - 'a']++;
            }
            
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                
                if (ch < s.charAt(idx)) {
                    idx = i;
                }
                
                if (--rec[ch - 'a'] == 0) {
                    break;
                }
            }
            
            result += s.charAt(idx);
            s = s.substring(idx + 1).replaceAll(String.valueOf(s.charAt(idx)), "");
        }
        
        return result;
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        int[] last = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            
            if (visited[idx]) {
                continue;
            }
            
            while (!stack.empty() && idx < stack.peek() && i < last[stack.peek()]) {
                visited[stack.pop()] = false;
            }
            
            stack.push(idx);
            visited[idx] = true;
        }
        
        String str = "";
        
        for (Integer i : stack) {
            str += (char) ('a' + i);
        }
        
        return str;
    }
}
