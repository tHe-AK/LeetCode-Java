class Solution {
    public int minAddToMakeValid(String S) {
        int left = 0;
        int right = 0;
        
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                left++;
            } else {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        
        return left + right;
    }
}
