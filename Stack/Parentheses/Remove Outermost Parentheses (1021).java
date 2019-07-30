class Solution {
    public String removeOuterParentheses(String S) {
        int left = 0;
        StringBuilder sb = new StringBuilder();
        
        for (char ch : S.toCharArray()) {
            if (ch == '(' && left++ > 0) {
                sb.append(ch);
            } else if (ch == ')' && --left > 0) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
