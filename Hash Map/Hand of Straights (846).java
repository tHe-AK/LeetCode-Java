class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        int curr = 0;
        int prev = -1;
        
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            int diff = val - curr;
            
            if ((curr > 0 && prev + 1 != key) || diff < 0) {
                return false;
            }
            
            curr = val;
            prev = key;
            
            if (diff > 0) {
                count.put(key + W - 1, diff);
            }
            
            if (count.containsKey(key)) {
                curr -= count.remove(key);
            }
        }
        
        return curr == 0;
    }
}
