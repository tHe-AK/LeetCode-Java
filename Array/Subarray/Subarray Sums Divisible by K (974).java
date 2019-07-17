class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        
        for (int i : A) {
            sum = (sum + i % K + K) % K;
            int val = map.getOrDefault(sum, 0);
            count += val;
            map.put(sum, val + 1);
        }
        
        return count;
    }
}
