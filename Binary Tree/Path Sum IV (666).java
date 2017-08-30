class Solution {
    public int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[1];
        
        for (int num : nums) {
            int idx = (1 << (num / 100 - 1)) + (num / 10 % 10 - 1);
            map.put(idx, num % 10);
        }
        
        pathSum(1, 0, map, res);
        
        return res[0];
    }
    
    private void pathSum(int idx, int sum, Map<Integer, Integer> map, int[] res) {
        if (!map.containsKey(idx)) {
            return;
        }
        
        sum += map.get(idx);
        int left = idx * 2;
        int right = idx * 2 + 1;
        
        if (!map.containsKey(left) && !map.containsKey(right)) {
            res[0] += sum;
            return;
        }

        pathSum(left, sum, map, res);
        pathSum(right, sum, map, res);
    }
}
