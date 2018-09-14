class Solution {
    public int maxChunksToSorted(int[] arr) {
        int N = arr.length;
        int[] max = new int[N];
        max[0] = arr[0];
        int ans = 0;
        
        for (int i = 1; i < N; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = N - 1; i >= 0; i--) {
            if (max[i] <= min) {
                ans++;
            }
            
            min = Math.min(min, arr[i]);
        }
        
        return ans;
    }
}
