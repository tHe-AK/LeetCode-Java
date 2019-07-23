class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return helper(A, K) - helper(A, K - 1);
    }
    
    private int helper(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int res = 0;
        
        while (end < A.length) {
            map.put(A[end], map.getOrDefault(A[end++], 0) + 1);
            
            while (map.size() > K) {
                int key = A[start++];
                map.put(key, map.get(key) - 1);
                
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }
            
            res += end - start;
        }
        
        return res;
    }
}
