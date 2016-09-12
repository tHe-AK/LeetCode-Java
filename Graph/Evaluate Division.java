public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || values == null || queries == null) {
            throw new IllegalArgumentException();
        }
        
        Map<String, Map<String, Double>> rec = new HashMap<String, Map<String, Double>>();
        double[] results = new double[queries.length];
        
        for (int i = 0; i < equations.length; i++) {
            String dividend = equations[i][0];
            String divisor = equations[i][1];
            double value = values[i];
            
            addToMap(rec, dividend, divisor, value);
            addToMap(rec, divisor, dividend, 1 / value);
        }
        
        for (int i = 0; i < queries.length; i++) {
            results[i] = findInMap(rec, queries[i][0], queries[i][1], 1, new HashSet<String>());
        }
        
        return results;
    }
    
    private void addToMap(Map<String, Map<String, Double>> rec, String dividend, String divisor, double value) {
        if (!rec.containsKey(dividend)) {
            rec.put(dividend, new HashMap<String, Double>());
        }
        
        Map<String, Double> val = rec.get(dividend);
        val.put(divisor, value);
    }
    
    private double findInMap(Map<String, Map<String, Double>> rec, String dividend, String divisor, double cur, Set<String> visited) {
        if (!rec.containsKey(dividend)) {
            return -1;
        }
        
        if (dividend.equals(divisor)) {
            return cur;
        }
        
        visited.add(dividend);
        Map<String, Double> map = rec.get(dividend);
        
        for (String key : map.keySet()) {
            if (!visited.contains(key)) {
                double result = findInMap(rec, key, divisor, cur * map.get(key), visited);
                
                if (result != -1) {
                    return result;
                }
            }
        }
        
        return -1;
    }
}
