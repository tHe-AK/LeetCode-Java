class Solution {
    public boolean isRationalEqual(String S, String T) {
        return helper(S) == helper(T);
    }
    
    private double helper(String str) {
        int idx = str.indexOf("(");
        String num = "";
        
        if (idx == -1) {
            num += str;
        } else {
            num += str.substring(0, idx);
            
            while (num.length() <= 18) {
                num += str.substring(idx + 1, str.length() - 1);
            }
        }
        
        return Double.parseDouble(num);
    }
}
