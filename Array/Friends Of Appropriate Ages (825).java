class Solution {
    public int numFriendRequests(int[] ages) {
        int N = 120;
        int[] counts = new int[N + 1];
        int res = 0;
        
        for (int age : ages) {
            counts[age]++;
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                res += helper(counts, i, j);
            }
        }
        
        return res;
    }
    
    private int helper(int[] counts, int i, int j) {
        if (j <= i * 0.5 + 7) {
            return 0;
        }
        
        if (j > i) {
            return 0;
        }
        
        if (j > 100 && i < 100) {
            return 0;
        }
        
        int count = 0;
        
        if (i == j) {
            return (counts[i] - 1) * counts[i];
        } else {
            return counts[i] * counts[j];
        }
    }
}
