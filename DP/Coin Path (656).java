public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        int[] cost = new int[n];
        cost[n - 1] = A[n - 1] == -1 ? Integer.MAX_VALUE : 0;
        int[] next = new int[n];
        
        for (int i = n - 2; i >= 0; i--) {
            cost[i] = Integer.MAX_VALUE;
            
            if (A[i] != -1) {
                for (int j = i + 1; j <= Math.min(i + B, n - 1); j++) {
                    if (cost[j] != Integer.MAX_VALUE && cost[j] + A[j] < cost[i]) {
                        cost[i] = cost[j] + A[j];
                        next[i] = j;
                    } 
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        if (cost[0] != Integer.MAX_VALUE) {
            int i = 0;
            
            while (next[i] != 0) {
                res.add(i + 1);
                i = next[i];
            }
            
            res.add(i + 1);
        }
        
        return res;
    }
}
