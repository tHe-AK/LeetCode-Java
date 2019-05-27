class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        
        while (i >= 0 || j >= 0) {
            int count = 0;
            
            while (i >= 0 && (count > 0 || S.charAt(i) == '#')) {
                count += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            
            count = 0;
            
            while (j >= 0 && (count > 0 || T.charAt(j) == '#')) {
                count += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        
        return i == -1 && j == -1;
    }
}
