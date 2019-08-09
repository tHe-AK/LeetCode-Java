class Solution {
    public String minimizeError(String[] prices, int target) {
        double min = dfs(prices, 0, target, new HashMap<>());
        return min == Double.MAX_VALUE ? "-1" : String.format("%.3f", min);
    }
    
    private double dfs(String[] prices, int i, int target, Map<String, Double> map) {
        if (i == prices.length) {
            if (target == 0) {
                return 0;
            } else {
                return Double.MAX_VALUE;
            }
        }
        
        if (target < 0) {
            return Double.MAX_VALUE;
        }
        
        String key = i + " " + target;
        
        if (map.containsKey(key)) {
            return map.get(key);
        }
                
        double num = Double.parseDouble(prices[i]);
        int floor = (int) Math.floor(num);
        int ceil = (int) Math.ceil(num);
        double min = Double.MAX_VALUE;
        double floorDiff = dfs(prices, i + 1, target - floor, map);
        double ceilDiff = dfs(prices, i + 1, target - ceil, map);
        
        if (floorDiff != Double.MAX_VALUE) {
            min = Math.min(min, floorDiff + num - floor);
        }
        
        if (ceilDiff != Double.MAX_VALUE) {
            min = Math.min(min, ceilDiff + ceil - num);
        }
        
        map.put(key, min);
        return min;
    }
}
