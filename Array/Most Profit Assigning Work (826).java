class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = 0;
        
        for (int i = 0; i < difficulty.length; i++) {
            int key = difficulty[i];
            int val = Math.max(profit[i], map.getOrDefault(key, 0));
            map.put(key, val);
        }
        
        int max = 0;
        
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
            map.put(key, max);
        }
        
        for (int diff : worker) {
            Integer key = map.floorKey(diff);
            
            if (key != null) {
                res += map.get(key);
            }
        }
        
        return res;
    }
}
