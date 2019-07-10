class Solution {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            
            if (val == 0) {
                continue;
            }
            
            int nextKey = key > 0 ? key * 2 : key / 2;
            
            if (map.getOrDefault(nextKey, 0) >= val) {
                map.put(nextKey, map.get(nextKey) - val);
            } else {
                return false;
            }
        }
        
        return true;
    }
}
