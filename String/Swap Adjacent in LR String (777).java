class Solution {
    public boolean canTransform(String start, String end) {
        int l = 0;
        int r = 0;
        
        for (int i = 0; i < start.length(); i++) {
            char ch1 = start.charAt(i);
            char ch2 = end.charAt(i);
            
            if (ch1 == 'L') {
                l++;
            } else if (ch1 == 'R') {
                r++;
            }
            
            if (ch2 == 'L') {
                l--;
            } else if (ch2 == 'R') {
                r--;
            }
            
            if (l > 0 || r < 0 || (r > 0 && l < 0)) {
                return false;
            }
        }
        
        return l == 0 && r == 0;
    }
}
