class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int curr = 0;
        int max = 0;
        
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, curr + A[i] - i);
            curr = Math.max(curr, A[i] + i);
        }
        
        return max;
    }
}
