class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int low = 0;
        int high = tokens.length - 1;
        int curr = 0;
        int max = 0;
        
        while (low <= high) {
            if (P >= tokens[low]) {
                P -= tokens[low++];
                max = Math.max(max, ++curr);
            } else if (curr > 0) {
                P += tokens[high--];
                curr--;
            } else {
                break;
            }
        }
        
        return max;
    }
}
