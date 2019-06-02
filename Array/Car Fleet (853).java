class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
        
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], 1.0 * (target - position[i]) / speed[i]);
        }
        
        double max = 0;
        int ans = 0;
        
        for (Double val : map.values()) {
            if (val > max) {
                max = val;
                ans++;
            }
        }
        
        return ans;
    }
}
