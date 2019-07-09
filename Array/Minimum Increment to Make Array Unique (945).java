class Solution {
    public int minIncrementForUnique(int[] A) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        
        for (int i : A) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        
        int need = 0;
        int res = 0;
        
        for (Integer key : count.keySet()) {
            int val = count.get(key);
            res += val * Math.max(need - key, 0) + (val - 1) * val / 2;
            need = Math.max(need, key) + val;
        }
        
        return res;
    }
}
