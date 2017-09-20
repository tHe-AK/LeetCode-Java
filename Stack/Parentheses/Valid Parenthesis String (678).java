class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        
        for (char ch: s.toCharArray()) {
            low += ch == '(' ? 1 : -1;
            high += ch != ')' ? 1 : -1;
            
            if (high < 0) {
                return false;
            }
            
            low = Math.max(low, 0);
        }
        
        return low == 0;
    }
}

class Solution {
    public boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }
    
    private boolean checkValidString(String s, int i, int count) {
        if (count < 0) {
            return false;
        }
        
        if (i == s.length()) {
            return count == 0;
        }
        
        char ch = s.charAt(i);
        
        if (ch == '(') {
            return checkValidString(s, i + 1, count + 1);
        } else if (ch == ')') {
            return checkValidString(s, i + 1, count - 1);
        } else {
            return checkValidString(s, i + 1, count) || checkValidString(s, i + 1, count + 1) || checkValidString(s, i + 1, count - 1);
        }
    }
}
