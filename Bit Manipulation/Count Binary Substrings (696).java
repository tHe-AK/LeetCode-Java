class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0;
        int curr = 1;
        int count = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                pre = curr;
                curr = 1;
            }
            
            if (curr <= pre) {
                count++;
            }
        }
        
        return count;
    }
}

class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0;
        int curr = 1;
        int count = 0;
        
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                count += Math.min(pre, curr);
                pre = curr;
                curr = 1;
            }
        }
        
        return count;
    }
}
