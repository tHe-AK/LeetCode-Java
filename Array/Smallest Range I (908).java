class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];
        
        for (int x: A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        
        return Math.max(max - min - 2 * K, 0);
    }
}
