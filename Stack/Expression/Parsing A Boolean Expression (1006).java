class Solution {
    public boolean parseBoolExpr(String expression) {
        if (expression.length() == 1) {
            return expression.equals("t");
        }
        
        Character operator = expression.charAt(0);
        int i = 2;
        
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            
            boolean val = false;

            if (ch == 't' || ch == 'f') {
                val = ch == 't';
                i += 2;
            } else {
                int start = i;
                int count = 1;
                i += 2;
                
                while (count > 0) {
                    if (expression.charAt(i) == '(') {
                        count++;
                    } else if (expression.charAt(i) == ')') {
                        count--;
                    }
                    
                    i++;
                }
                
                val = parseBoolExpr(expression.substring(start, i++));
            }
            
            if (operator == '!') {
                return !val;
            } else if (operator == '&') {
                if (!val) {
                    return false;
                }
            } else {
                if (val) {
                    return true;
                }
            }
        }
        
        return operator == '&';
    }
}
