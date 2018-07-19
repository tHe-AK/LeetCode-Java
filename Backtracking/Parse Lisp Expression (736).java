class Solution {
    public int evaluate(String expression) {
        return evaluate(expression, new HashMap<>());
    }
    
    private int evaluate(String expression, Map<String, Integer> map) {
        if (expression.startsWith("(add")) {
            int i = 5;
            String str1 = getStr(expression, i);
            i += str1.length() + 1;
            String str2 = getStr(expression, i);
            return getVal(str1, map) + getVal(str2, map);
        } else if (expression.startsWith("(mult")) {
            int i = 6;
            String str1 = getStr(expression, i);
            i += str1.length() + 1;
            String str2 = getStr(expression, i);
            return getVal(str1, map) * getVal(str2, map);
        } else {
            int i = 5;
            String exp = null;
            
            while (i < expression.length()) {
                if (exp == null) {
                    exp = getStr(expression, i);
                    i += exp.length() + 1;
                } else {
                    String str = getStr(expression, i);
                    i += str.length() + 1;
                    map.put(exp, getVal(str, map));
                    exp = null;
                }
            }
            
            return getVal(exp, map);
        }
    }
    
    private String getStr(String expression, int i) {
        if (expression.charAt(i) == '(') {
            int left = 1;
            int j = i + 1;
            
            while (j < expression.length()) {
                char ch = expression.charAt(j++);
                
                if (ch == '(') {
                    left++;
                } else if (ch == ')') {
                    left--;
                    
                    if (left == 0) {
                        break;
                    }
                }
            }
            
            return expression.substring(i, j);
        } else {
            int j = i + 1;
            
            while (expression.charAt(j) != ' ' && expression.charAt(j) != ')') {
                j++;
            }
            
            return expression.substring(i, j);
        }
    }
    
    private int getVal(String expression, Map<String, Integer> map) {
        char ch = expression.charAt(0);
        
        if (ch == '(') {
            return evaluate(expression, new HashMap<>(map));
        } else if (Character.isLetter(ch)) {
            return map.get(expression);
        } else {
            return Integer.parseInt(expression);
        }
    }
}
