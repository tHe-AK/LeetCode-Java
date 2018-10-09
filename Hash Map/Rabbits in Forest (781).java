class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int ans : answers) {
            int key = ans + 1;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        for (Integer key : map.keySet()) {
            int val = map.get(key);
            count += (val + key - 1) / key * key;
        }
        
        return count;
    }
}
