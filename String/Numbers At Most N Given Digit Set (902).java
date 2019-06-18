class Solution {
    public int atMostNGivenDigitSet(String[] D, int N) {
        String str = String.valueOf(N);
        int len = str.length();
        int count = D.length;
        int res = 0;
        
        for (int i = 1; i < str.length(); i++) {
            res += Math.pow(count, i);
        }
        
        int i = 0;
        
        while (i < len) {
            char ch = str.charAt(i);
            int j = 0;
            
            while (j < D.length && D[j].charAt(0) < ch) {
                res += Math.pow(count, len - i - 1);
                j++;
            }
            
            if (j == count || D[j].charAt(0) != ch) {
                break;
            }
            
            i++;
        }
        
        return res + (i == len ? 1 : 0);
    }
}
