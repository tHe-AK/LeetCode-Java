class Solution {
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char[] array = S.toCharArray();
            Arrays.sort(array);
            return String.valueOf(array);
        }
        
        String min = S;
        
        for (int i = 0; i < S.length() - 1; i++) {
            S = S.substring(1) + S.charAt(0);
            
            if (min.compareTo(S) > 0) {
                min = S;
            }
        }
        
        return min;
    }
}
