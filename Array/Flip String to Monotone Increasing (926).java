class Solution {
    public int minFlipsMonoIncr(String S) {
        int N = S.length();
        int left = 0;
        int[] right = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            right[i] = S.charAt(i) == '0' ? 1 : 0;
            
            if (i < N - 1) {
                right[i] += right[i + 1];
            }
        }
        
        int min = Math.min(right[0], N - right[0]);
        
        for (int i = 0; i < N - 1; i++) {
            left += S.charAt(i) == '1' ? 1 : 0;
            min = Math.min(min, left + right[i + 1]);
        }
        
        return min;
    }
}
