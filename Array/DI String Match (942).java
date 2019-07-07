class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int low = 0;
        int high = N;
        int[] res = new int[N + 1];
        
        for (int i = 0; i < N; i++) {
            res[i] = S.charAt(i) == 'I' ? low++ : high--;
        }
        
        res[N] = low;
        return res;
    }
}
