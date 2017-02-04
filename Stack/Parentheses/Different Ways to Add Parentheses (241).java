public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input, new HashMap<String, List<Integer>>());
    }
    
    private List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                
                for (int x : left) {
                    for (int y : right) {
                        if (ch == '+') {
                            result.add(x + y);
                        } else if (ch == '-') {
                            result.add(x - y);
                        } else if (ch == '*') {
                            result.add(x * y);
                        }
                    }
                }
            }
        }
        
        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }
        
        map.put(input, result);
        
        return result;
    }
}
