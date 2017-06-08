public class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        
        while (i < code.length()) {
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                
                if (i < 0) {
                    return false;
                }
                
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf('>', j);
                
                if (!isNameValid(code, j, i)) {
                    return false;
                }

                String name = code.substring(j, i++);
                
                if (stack.isEmpty() || !stack.pop().equals(name)) {
                    return false;
                }
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf('>', j);
                
                if (!isNameValid(code, j, i)) {
                    return false;
                }
                
                String name = code.substring(j, i++);
                stack.push(name);
            } else {
                i++;
            }
            
            if (i < code.length() && stack.isEmpty()) {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isNameValid(String code, int start, int end) {
        if (end < 0 || start == end || end - start > 9) {
            return false;
        }
                
        for (int k = start; k < end; k++) {
            if (!Character.isUpperCase(code.charAt(k))) {
                return false;
            }
        }
        
        return true;
    }
}
