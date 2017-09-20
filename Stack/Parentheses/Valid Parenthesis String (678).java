class Solution {
    public boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }
    
    private boolean checkValidString(String s, int i, int count) {
        if (i == s.length()) {
            return count == 0;
        }
        
        char ch = s.charAt(i);
        
        if (ch == '(') {
            return checkValidString(s, i + 1, count + 1);
        } else if (ch == ')') {
            return count > 0 && checkValidString(s, i + 1, count - 1);
        } else {
            return checkValidString(s, i + 1, count) || checkValidString(s, i + 1, count + 1) || (count > 0 && checkValidString(s, i + 1, count - 1));
        }
    }
}
