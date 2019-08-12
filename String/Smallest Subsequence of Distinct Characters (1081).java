class Solution {
    public String smallestSubsequence(String text) {
        String result = "";
        
        while (text.length() > 0) {
            int len = text.length();
            int[] rec = new int[26];
            int idx = 0;
            
            for (int i = 0; i < len; i++) {
                rec[text.charAt(i) - 'a']++;
            }
            
            for (int i = 0; i < len; i++) {
                char ch = text.charAt(i);
                
                if (ch < text.charAt(idx)) {
                    idx = i;
                }
                
                if (--rec[ch - 'a'] == 0) {
                    break;
                }
            }
            
            result += text.charAt(idx);
            text = text.substring(idx + 1).replaceAll(String.valueOf(text.charAt(idx)), "");
        }
        
        return result;
    }
}

class Solution {
    public String smallestSubsequence(String text) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        int[] last = new int[26];
        
        for (int i = 0; i < text.length(); i++) {
            last[text.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < text.length(); i++) {
            int idx = text.charAt(i) - 'a';
            
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
