public class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                int start = i++;
                
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                
                int count = Integer.parseInt(s.substring(start, i));
                int left = 1;
                start = ++i;
                
                while (i < s.length()) {
                    if (s.charAt(i) == '[') {
                        left++;
                    } else if (s.charAt(i) == ']') {
                        left--;
                        
                        if (left == 0) {
                            break;
                        }
                    }
                    
                    i++;
                }

                String str = decodeString(s.substring(start, i));
                
                for (int j = 0; j < count; j++) {
                    result.append(str);
                }
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<Integer>();
        Stack<StringBuilder> strs = new Stack<StringBuilder>();
        StringBuilder result = new StringBuilder();
        strs.push(result);
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '[') {
                strs.push(new StringBuilder());
            } else if (ch == ']') {
                int count = counts.pop();
                StringBuilder str = strs.pop();

                for (int j = 0; j < count; j++) {
                    strs.peek().append(str);
                }
            } else if (Character.isDigit(ch)) {
                int start = i;
                
                while (Character.isDigit(s.charAt(i + 1)) && i + 1 < s.length()) {
                    i++;
                }
                
                counts.push(Integer.parseInt(s.substring(start, i + 1)));
            } else {
                strs.peek().append(ch);
            }
        }
        
        return result.toString();
    }
}

public class Solution {
    public String decodeString(String s) {
        return decodeString(s, new int[] { 0 });
    }
    
    private String decodeString(String s, int[] idx) {
        StringBuilder result = new StringBuilder();

        while (idx[0] < s.length()) {
            char ch = s.charAt(idx[0]);
            
            if (Character.isDigit(ch)) {
                int start = idx[0]++;
                
                while (idx[0] < s.length() && Character.isDigit(s.charAt(idx[0]))) {
                    idx[0]++;
                }
                
                int count = Integer.parseInt(s.substring(start, idx[0]));
                
                idx[0]++;
                String str = decodeString(s, idx);
                
                for (int i = 0; i < count; i++) {
                    result.append(str);
                }
            } else if (ch == ']') {
                return result.toString();
            } else {
                result.append(ch);
            }
            
            idx[0]++;
        }
        
        return result.toString(); 
    }
}
